package r3.game.enums;

public enum CellType {
	EMPTY_CELL, CROSS_CELL, NOUGHT_CELL;
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		switch(this) {
			case CROSS_CELL:{
				builder.append(" X ");
				break;
			}
			case NOUGHT_CELL:{
				builder.append(" O ");
				break;
			}
			default : {
				builder.append("   ");
				break;
			}
		}
		return builder.toString();
	}
}