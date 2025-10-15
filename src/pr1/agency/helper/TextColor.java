package pr1.agency.helper;

public enum TextColor {
	WHITE("1;37"), LIGHT_GREY("0;37"), DARK_GREY("1;30"), BLACK("0;30"), BLUE("0;34"), LIGHT_BLUE("1;34"),
	GREEN("0;32"), LIGHT_GREEN("1;32"), CYAN("0;36"), LIGHT_CYAN("1;36"), RED("0;31"), LIGHT_RED("1;31"),
	PURPLE("0;35"), LIGHT_PURPLE("1;35"), YELLOW("1;33"), BROWN("0;33"), DEFAULT("0");

	private final String code;

	TextColor(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
