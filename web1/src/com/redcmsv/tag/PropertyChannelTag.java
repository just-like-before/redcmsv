package com.redcmsv.tag;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.redcmsv.beans.Channel;

public class PropertyChannelTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;

	@SuppressWarnings("rawtypes")
	@Override
	public int doEndTag() throws JspException {
		String result = null;
		Tag parentTag = this.getParent();
		if(parentTag instanceof WebAllChannelTag) {
			WebAllChannelTag parent = (WebAllChannelTag)parentTag;
			Channel currentChannel = parent.getCurrentChannel();
			Class cl = currentChannel.getClass();
			result = currentChannel.getChannelAttrMap().get(name);
			if(result == null || "".equals(result)) {
				try {
					Field f = cl.getDeclaredField(name);
					f.setAccessible(true);
					result = f.get(currentChannel).toString();
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			
			try {
				pageContext.getOut().print(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
