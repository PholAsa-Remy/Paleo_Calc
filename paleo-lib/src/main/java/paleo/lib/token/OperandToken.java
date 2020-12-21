package paleo.lib.token;

/**
 * Models a generic operand type.
 */
public interface OperandToken extends Yytoken {
	/**
	 * Default implementation of the {@link Yytoken} function.
	 *
	 * @return Always true.
	 */
	@Override
	default boolean isAnOperandToken() {
		return true;
	}
}
