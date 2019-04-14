package ObjectMap;
/**
 * 
 * @author Jijo
 *
 */
public enum  CalculatorObjectMap {
	//Home
	CALC__LEFTINPUTFIELD_XPATH ("//android.widget.EditText[@content-desc='inputFieldLeft']"),
	CALC__RIGHTINPUTFIELD_XPATH ("//android.widget.EditText[@content-desc='inputFieldRight']"),
	CALC__ADDITIONBUTTON_XPATH ("//android.widget.Button[@content-desc='additionButton']"),
	CALC__SUBTRACTIONBUTTON_XPATH ("//android.widget.Button[@content-desc='subtractButton']"),
	CALC__MULTIPLICATIONBUTTON_XPATH ("//android.widget.Button[@content-desc='multiplicationButton']"),
	CALC__DIVISIONBUTTON_XPATH ("//android.widget.Button[@content-desc='divisionButton']"),
	CALC__RESETBUTTON_XPATH ("//android.widget.Button[@content-desc='resetButton']"),
	CALC__RESULTVIEW_XPATH ("//android.widget.TextView[@content-desc='resultTextView']"),
	//DUMMY WEB ELEMENT DO NOT DELETE
	CALC_XPATH_ID ("ENDS");

	
//the methods below MUST be in the enum or this will not work
private final String enumValue;       

	private CalculatorObjectMap(String s) {
	 	enumValue = s;
	}
		   
	public String getValue () {
		return enumValue;
	}
	
	public String toString() {
		return getValue();	
	}
}