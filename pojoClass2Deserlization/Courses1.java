package pojoClass2Deserlization;

import java.util.List;

public class Courses1 
{
	private List<WebAutomation1> webAutomation;
	public List<WebAutomation1> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation1> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<API1> getApi() {
		return api;
	}
	public void setApi(List<API1> api) {
		this.api = api;
	}
	public List<Mobile1> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile1> mobile) {
		this.mobile = mobile;
	}
	private List<API1> api;
	private List<Mobile1> mobile;
	
	
}
