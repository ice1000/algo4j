package org.algo4j.math;

/**
 * Created by ice1000 on 2016/12/18.
 *
 * @author ice1000
 */
@SuppressWarnings({"unused", "WeakerAccess"})

//TODO 我认为将此类放入package-info中并限制访问权限更好。但如此Test可能无法运行。
public final class Constants {
	private Constants() {
		throw new Error("do not instantiation me");
	}

	/** m * s^-1 */
	public static final int LIGHT_SPEED = 299792458;

	/** J * s */
	public static final double PLANK_CONSTANT = 6.6261e-34;

	/** C */
	public static final double ELEMENTARY_CHARGE = 1.6022e-19;

	/** m */
	public static final double PLANK_LENGTH = 1.61619997e-35;

	/** s */
	public static final double PLANK_TIME = 5.3910632e-44;

	/** kg */
	public static final double PLANK_MASS = 2.1765113e-8;

	/** C */
	public static final double PLANK_CHARGE = 1.87554595641e-18;

	/** K */
	public static final double PLANK_TEMPERATURE = 1.41683385e32;

	/** m^3 * kg^-1 * s^-1 */
	public static final double GRAVITATION_CONSTANT = 6.6740831e-11;
}
