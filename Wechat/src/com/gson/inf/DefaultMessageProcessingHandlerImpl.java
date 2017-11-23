/**
 * 微信公众平台开发模式(JAVA) SDK
 */
package com.gson.inf;

import java.util.ArrayList;
import java.util.List;

import com.gson.bean.Articles;
import com.gson.bean.InMessage;
import com.gson.bean.NewsOutMessage;
import com.gson.bean.OutMessage;
import com.gson.bean.TextOutMessage;

public class DefaultMessageProcessingHandlerImpl implements MessageProcessingHandler{

	private OutMessage outMessage;
	
	@Override
	public void allType(InMessage msg){
		TextOutMessage out = new TextOutMessage();
		out.setContent("您的消息已经收到！");
		this.setOutMessage(out);
	}
	
	@Override
	public void textTypeMsg(InMessage msg) {
		TextOutMessage out = new TextOutMessage();
		out.setContent("消息类型是文本，内容是："+msg.getContent());
		this.setOutMessage(out);
	}

	@Override
	public void locationTypeMsg(InMessage msg) {
		TextOutMessage out = new TextOutMessage();
		String content="消息类型是坐标\n";
		content+="位置名称是:"+msg.getLabel()+"\n";
		content+="x坐标是:"+msg.getLocation_X()+"\n";
		content+="y坐标是:"+msg.getLocation_Y()+"\n";
		out.setContent(content);
		this.setOutMessage(out);
	}

	@Override
	public void imageTypeMsg(InMessage msg) {
		TextOutMessage out = new TextOutMessage();
		out.setContent("消息类型是图片");
		this.setOutMessage(out);
	}
	
	@Override
	public void videoTypeMsg(InMessage msg) {
	}
	
	@Override
	public void voiceTypeMsg(InMessage msg) {
		TextOutMessage out = new TextOutMessage();
		out.setContent("消息类型是语音，内容是:"+msg.getRecognition());
		this.setOutMessage(out);
	}

	@Override
	public void linkTypeMsg(InMessage msg) {
	}

	@Override
	public void eventTypeMsg(InMessage msg) {
		if(msg.getEvent().equals("subscribe")){
			//新闻类型消息
			NewsOutMessage out = new NewsOutMessage();
			//子内容列表
			List<Articles> articlesList= new ArrayList<Articles>();
			//子内容
			Articles a1=new Articles();
			a1.setPicUrl("http://219.224.135.67/Wechat/images/fengmian.jpg");
			a1.setTitle("欢迎来到北京旅游");
			a1.setUrl("http://219.224.135.67/Wechat/index.jsp?openId="+msg.getFromUserName());
			articlesList.add(a1);
			
			Articles a2=new Articles();
			a2.setPicUrl("http://219.224.135.67/Wechat/images/icon.png");
			a2.setTitle("推荐内容");
			a2.setUrl("http://219.224.135.67/Wechat/tuijian.jsp?openId="+msg.getFromUserName());
			articlesList.add(a2);
			
			Articles a3=new Articles();
			a3.setPicUrl("http://219.224.135.67/Wechat/images/icon.png");
			a3.setTitle("位置服务");
			a3.setUrl("http://219.224.135.67/Wechat/weizhi.jsp?openId="+msg.getFromUserName());
			articlesList.add(a3);
			
			out.setArticles(articlesList);
			this.setOutMessage(out);
		}
	}
	
	@Override
	public void setOutMessage(OutMessage outMessage) {
		this.outMessage = outMessage;
	}
	
	@Override
	public void afterProcess(InMessage inMessage,OutMessage outMessage) {
	}
	
	@Override
	public OutMessage getOutMessage() {
		return outMessage;
	}
}
