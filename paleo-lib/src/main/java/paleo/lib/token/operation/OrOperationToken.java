package paleo.lib.token.operation;

/**
 * Models the boolean OR operation.
 */
public final class OrOperationToken implements OperationToken {

	public static final Priority priority = Priority.LOW; ///< Is the operation priority for evaluation.
	public static final int arity = 2; ///< Is the operation arity.

	@Override
	public String toString() {
		return getClass().toString();
	}

	/**
	 * @return the operation priority.
	 */
	public int getPriority() {
		return priority.getPriority();
	}

	/**
	 * @return the operation arity.
	 */
	public int getArity() {
		return arity;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof OrOperationToken;
	}
}
