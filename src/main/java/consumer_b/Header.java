package consumer_b;

/**
 * Header of evento class
 * @author pedro.alonso.garcia
 *
 */
public class Header {

	String UID;
	String Event_type;
	String Event_subtype;
	String Event_origin_service;
	String Timestamp;
	String Criticality;
	
	public Header(String uID, String event_type, String event_subtype, String event_origin_service, String timestamp,
			String criticality) {
		super();
		UID = uID;
		Event_type = event_type;
		Event_subtype = event_subtype;
		Event_origin_service = event_origin_service;
		Timestamp = timestamp;
		Criticality = criticality;
	}
	public Header() {
		super();
		setCriticality("1");
	    setEvent_origin_service("Servicio origen");
	    setEvent_subtype("subtipo de servicio");
	    setEvent_type("tipo de evento");
	    setTimestamp("22-06-2016");
	    setUID("ID1234567890");
	}
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getEvent_type() {
		return Event_type;
	}
	public void setEvent_type(String event_type) {
		Event_type = event_type;
	}
	public String getEvent_subtype() {
		return Event_subtype;
	}
	public void setEvent_subtype(String event_subtype) {
		Event_subtype = event_subtype;
	}
	public String getEvent_origin_service() {
		return Event_origin_service;
	}
	public void setEvent_origin_service(String event_origin_service) {
		Event_origin_service = event_origin_service;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getCriticality() {
		return Criticality;
	}
	public void setCriticality(String criticality) {
		Criticality = criticality;
	}
	
}
