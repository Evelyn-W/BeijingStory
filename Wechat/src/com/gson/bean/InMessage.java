
package com.gson.bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.gson.inf.MsgTypes;

public class InMessage {
	//前5个为基本类型
	//开发者微信号
	private String ToUserName;
	//发送方账号（openId，对于公众号唯一）
	private String FromUserName;
	//创建时间
	private Long CreateTime;
	//消息类型(text/image/location/link/voicd)，缺省为text
	private String MsgType;// = "text";
	//消息ID 64位整形
	private Long MsgId;
	
	
	// 文本消息
	private String Content;
	
	// 图片消息 微信服务器链接
	private String PicUrl;
	
	// 位置消息
	//维度
	private String Location_X;
	//经度
	private String Location_Y;
	//地图缩放大小
	private Long Scale;
	//地理位置信息
	private String Label;
	
	// 链接消息
	// 消息标题
	private String Title;
	// 消息描述
	private String Description;
	// 消息链接
	private String Url;
	
	// 语音信息
	//媒体 ID
	private String MediaId;
	//语音格式
	private String Format;
	//语音识别结果,utf8编码
	private String Recognition;
	
	
	// 事件
	// 事件类型名
	private String Event;
	// 二维码事件key
	private String EventKey;
	// 换取二维码图片
	private String Ticket;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public Long getScale() {
		return Scale;
	}

	public void setScale(Long scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String, Object>();
		Field[] fields = InMessage.class.getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if(obj!=null){
					map.put(field.getName(), obj);
				}
				map.remove("ToUserName");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public Boolean isEvent(){
		return this.MsgType.equals(MsgTypes.EVENT.getType());
	}
	
	public Boolean isText(){
		return this.MsgType.equals(MsgTypes.TEXT.getType());
	}
	
	public Boolean isImage(){
		return this.MsgType.equals(MsgTypes.IMAGE.getType());
	}
	
	public Boolean isVoice(){
		return this.MsgType.equals(MsgTypes.VOICE.getType());
	}
	
	public Boolean isVideo(){
		return this.MsgType.equals(MsgTypes.VIDEO.getType());
	}
	
	public Boolean isLocation(){
		return this.MsgType.equals(MsgTypes.LOCATION.getType());
	}
	
	public Boolean isLink(){
		return this.MsgType.equals(MsgTypes.LINK.getType());
	}
}
