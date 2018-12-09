package com.redcmsv.daoImp;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;

//操作数据库的工具类
public class Db {
	
	//日志
	private static Logger log=Logger.getLogger(Db.class);
	private static QueryRunner run=new QueryRunner();
	private static DruidDataSource ds=null;
	
	//只放进行事务的Connection
	private static ThreadLocal<Connection> conn=new ThreadLocal<Connection>();
	static{
	//初始化连接池
		try {
			ResourceBundle res=ResourceBundle.getBundle("jdbc");
			
			ds=new DruidDataSource();
			ds.setUrl(res.getString("url"));
			ds.setDriverClassName(res.getString("driverClassName"));
			ds.setUsername(res.getString("username"));
			ds.setPassword(res.getString("password"));
			ds.setFilters(res.getString("filters"));
			ds.setMaxActive(Integer.parseInt(res.getString("maxActive")));
			ds.setInitialSize(Integer.parseInt(res.getString("initialSize")));
			ds.setMaxWait(Long.parseLong(res.getString("maxWait")));
			ds.setMinIdle(Integer.parseInt(res.getString("minIdle")));
			ds.setValidationQuery("SELECT 'x'");
			ds.setTestWhileIdle(true);
			ds.setTestOnBorrow(false);
			ds.setTestOnReturn(false);
			ds.setTimeBetweenEvictionRunsMillis(600000);
			//ds.setMaxIdle(Integer.parseInt(res.getString("maxIdle")));
			
			//ds.setTimeBetweenEvictionRunsMillis(Long.parseLong(res.getString("timeBetweenEvictionRunsMillis")));
			//ds.setMinEvictableIdleTimeMillis(Long.parseLong(res.getString("minEvictableIdleTimeMillis")));
			//ds.setValidationQuery(res.getString("validationQuery"));
		} catch (Exception e) {
			log.error("com.redcms.db.Db.ERROR_003_初始化连接池失败");
		} 
	}
 
    /**
     * 通过DataSource得到Connection  
     */
	public static Connection getConnection() throws SQLException{ 
		
        //得到ThreadLocal中的connection  
        Connection con = conn.get(); 
        
        //如果开启了事务，则con不为空，应该直接返回con  
        if(null==con||con.isClosed()) {
        	con=ds.getConnection();
        	conn.set(con);
        }
        return con;  
    }  
      
    /**
     * 开启事务  
     */
    public static void beginTransaction() throws SQLException {
    	
        //得到ThreadLocal中的connection  
    	Connection con = getConnection();  
        //设置事务提交为手动  
        con.setAutoCommit(false);  
        //把当前开启的事务放入ThreadLocal中  
        conn.set(con);  
    }  
  
    /**
     * 提交事务  
     */
    public static void commitTransaction() throws SQLException {  
        //得到ThreadLocal中的connection  
        Connection con = conn.get();  
        //判断con是否为空，如果为空，则说明没有开启事务  
        if(con == null){  
            throw new SQLException("没有开启事务,不能提交事务");  
        }  
        //如果con不为空,提交事务  
        con.commit();  
        //事务提交后，关闭连接  
        con.close();  
        //将连接移出ThreadLocal  
        conn.remove();  
    }  
  
    /**
     * 回滚事务  
     */
    public static void rollbackTransaction() {  
        try {
			//得到ThreadLocal中的connection  
			Connection con = conn.get();  
			//判断con是否为空，如果为空，则说明没有开启事务，也就不能回滚事务  
			if(con == null){  
			    throw new SQLException("没有开启事务,不能回滚事务");  
			}  
			//事务回滚  
			con.rollback();  
			//事务回滚后，关闭连接  
			con.close();  
			//将连接移出ThreadLocal  
			conn.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
  
    /**
     * 关闭事务
     */
    public static void releaseConnection(Connection connection) throws SQLException {  
        //得到ThreadLocal中的connection  
        Connection con = conn.get();  
        //如果参数连接与当前事务连接不相等，则说明参数连接不是事务连接，可以关闭，否则交由事务关闭  
        if(connection != null && con != connection){  
            //如果连接没有被关闭，关闭之  
            if(!connection.isClosed()){  
                connection.close();  
            }  
        }  
    } 
	
    public static void closeDataSource() {
    	
	    if(null!=ds)ds.close();
    }
    //---------------------重写QueryRuner中的方法------------------------
     
    //批量处理
	public static  int[] batch(String sql, Object[][] params)  throws SQLException {  
	    Connection conn = getConnection();  
	    int[] result = run.batch(conn, sql, params);  
	    releaseConnection(conn);  
	    return result;  
	}  
  
 
	//查询
    public static <T> T query(String sql, ResultSetHandler<T> rsh,  
            Object... params) throws SQLException {  
        Connection conn = getConnection();  
        T result =  run.query(conn, sql, rsh, params);  
        releaseConnection(conn);  
        return result;  
    }  
  
    //查询
    public static <T> T query(String sql, ResultSetHandler<T> rsh)  
            throws SQLException {  
        Connection conn = getConnection();  
        T result =  run.query(conn, sql, rsh);  
        releaseConnection(conn);  
        return result;  
    }  
  
    //增删改 有参数
    public static int update(String sql, Object... params)  
            throws SQLException {  
        Connection conn = getConnection();  
        int result = run.update(conn, sql, params);  
        releaseConnection(conn);  
        return result;  
    }  

    //增删改
    public static  int update(String sql, Object param)  
            throws SQLException {  
        Connection conn = getConnection();  
        int result =  run.update(conn, sql, param);  
        releaseConnection(conn);  
        return result;  
    }  
  
    //增删改 没参数
    public static int update(String sql) throws SQLException {  
        Connection conn = getConnection();  
        int result =  run.update(conn, sql);  
        releaseConnection(conn);  
        return result;  
    } 
    
    //增加一个对象 通过sql使用反射 填充参数
    @SuppressWarnings("rawtypes")
	public static int insertObject(String sql,Object obj) throws SQLException {
		int start = sql.indexOf('(');
		int end = sql.indexOf(')');
		String str = sql.substring(start+1, end);
		String[] strArray = str.split(",");
		Class cl = obj.getClass();
		List<Object> list = new ArrayList<Object>();
		for(String s : strArray) {
			try {
				Field f = cl.getDeclaredField(s);
				f.setAccessible(true);
				if(f.getType() == int.class || f.getType() == Integer.class || f.getType() == Integer.TYPE) {
					int i = (Integer)f.get(obj);
					list.add(i);
				}else if(f.getType() == long.class || f.getType() == Long.class || f.getType() == Long.TYPE) {
					long l = (Long)f.get(obj);
					list.add(l);
				}else if(f.getType() == byte.class || f.getType() == Byte.class || f.getType() == Byte.TYPE){
					byte b = (Byte) f.get(obj);
					list.add(b);
				}else if(f.getType() == Date.class || f.getType() == Date.class){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date d = (Date)f.get(obj);
					list.add(sdf.format(d));
				}else {
					String string = (String)f.get(obj);
					list.add(string);
				}	
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int i = -1;
		i = update(sql,list.toArray());
		return i;
	}
    
    //增加一个对象 通过sql使用反射 填充参数 其中要的一个Long型的参数不是自己的属性
    @SuppressWarnings("rawtypes")
	public static int insertObject(String sql,long lo,Object obj) throws SQLException {
		int start = sql.indexOf('(');
		int end = sql.indexOf(')');
		String str = sql.substring(start+1, end);
		String[] strArray = str.split(",");
		Class cl = obj.getClass();
		List<Object> list = new ArrayList<Object>();
		list.add(lo);
		for(String s : strArray) {
			if("model_id".equals(s)) {
				
			}else {
				try {
					Field f = cl.getDeclaredField(s);
					f.setAccessible(true);
					if(f.getType() == int.class || f.getType() == Integer.class || f.getType() == Integer.TYPE) {
						int i = (Integer)f.get(obj);
						list.add(i);
					}else if(f.getType() == long.class || f.getType() == Long.class || f.getType() == Long.TYPE) {
						long l = (Long)f.get(obj);
						list.add(l);
					}else if(f.getType() == byte.class || f.getType() == Byte.class || f.getType() == Byte.TYPE){
						byte b = (Byte) f.get(obj);
						list.add(b);
					}else {
						String string = (String)f.get(obj);
						list.add(string);
					}	
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		int i = -1;
		i = update(sql,list.toArray());
		return i;
	}
	
    //修改一个对象 通过sql使用反射 填充参数 其中第三个参数是where之后的条件
	@SuppressWarnings("rawtypes")
	public static int updateObject(String sql,Object obj,Object...o) throws SQLException {
		
		int start = sql.indexOf("set") + 4;
		int end = sql.indexOf("where") - 1;
		String str = sql.substring(start, end);
		str += ",";
		str = str.replaceAll("=\\?", "");
		
		String[] strArray = str.split(",");
		List<Object> list = new ArrayList<Object>();
		Class cl = obj.getClass();
		for(String s : strArray) {
			try {
				Field f = cl.getDeclaredField(s);
				f.setAccessible(true);
				if(f.getType() == int.class || f.getType() == Integer.class || f.getType() == Integer.TYPE) {
					int i = (Integer)f.get(obj);
					list.add(i);
				}else if(f.getType() == long.class || f.getType() == Long.class || f.getType() == Long.TYPE) {
					long l = (Long)f.get(obj);
					list.add(l);
				}else if(f.getType() == byte.class || f.getType() == Byte.class || f.getType() == Byte.TYPE){
					byte b = (Byte) f.get(obj);
					list.add(b);
				}else {
					String string = (String)f.get(obj);
					list.add(string);
				}
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		for(Object oa : o) {
			if(oa instanceof Integer) {
				int i = (int)oa;
				list.add(i);
			}else if(oa instanceof Long) {
				long l = (long)oa;
				list.add(l);
			}else {
				String s = (String)oa;
				list.add(s);
			}
		}
		int i = -1;
		i = update(sql,list.toArray());
		return i;
	}
}	

