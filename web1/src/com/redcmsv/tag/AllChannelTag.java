package com.redcmsv.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.redcmsv.beans.Channel;
import com.redcmsv.beans.Model;
import com.redcmsv.service.ChannelService;
import com.redcmsv.service.ModelService;

public class AllChannelTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		List<Channel> channelList = ChannelService.selectChannelByParentId(0);
		StringBuffer sb = new StringBuffer();
		int i = 1;
		
		if(channelList != null && channelList.size() > 0) {
			for(Channel c : channelList) {
				sb.append("<tr>");
				sb.append("<td>"+(i++)+"</td>");
				sb.append("<td style='font-size: 15px;color: salmon;'>"+c.getName()+"</td>");
				Model model = ModelService.select(c.getModel_id());
				if(model != null) {
					sb.append("<td>"+model.getName()+"</td>");
					sb.append("<td>"+c.getPriority()+"</td>");
					sb.append("<td><a href='admin/channel?action=updateChannelToFoward&channel_id="+c.getId()+"' class='btn btn-danger'>修改</a></td>");
					sb.append("<td><a href='admin/channel?action=deleteChannel&channel_id="+c.getId()+"' class='btn btn-warning'>删除</a></td>");
					sb.append("<td><a href='#' class='btn btn-success'>发布</a></td>");
					sb.append("</tr>");
					List<Channel> childChannelList = ChannelService.selectChannelByParentId(c.getId());
					if(childChannelList != null && childChannelList.size() > 0) {
						for(Channel cl : childChannelList) {
							sb.append("<tr>");
							sb.append("<td align='center'>"+(i++)+"</td>");
							sb.append("<td>|---"+cl.getName()+"</td>");
							sb.append("<td>"+model.getName()+"</td>");
							sb.append("<td>"+cl.getPriority()+"</td>");
							sb.append("<td><a href='admin/channel?action=updateChannelToFoward&channel_id="+cl.getId()+"' class='btn btn-danger'>修改</a></td>");
							sb.append("<td><a href='admin/channel?action=deleteChannel&channel_id="+cl.getId()+"' class='btn btn-warning'>删除</a></td>");
							sb.append("<td><a href='#' class='btn btn-success'>发布</a></td>");
							sb.append("</tr>");
						}
					}
				}else {
					sb.append("<td></td>");
					sb.append("<td>"+c.getPriority()+"</td>");
					sb.append("<td><a href='admin/channel?action=updateChannelToFoward&channel_id="+c.getId()+"' class='btn btn-danger'>修改</a></td>");
					sb.append("<td><a href='admin/channel?action=deleteChannel&channel_id="+c.getId()+"\"' class='btn btn-warning'>删除</a></td>");
					sb.append("<td><a href='#' class='btn btn-success'>发布</a></td>");
					sb.append("</tr>");
				}
			}
		}
		this.getJspContext().getOut().println(sb.toString());
	}
}
