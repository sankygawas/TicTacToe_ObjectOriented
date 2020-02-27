/**
 * 
 */
package r3.game.enums;

/**
 *  ENUM to represent the GameState
 *  It holds 4 States - Playing, Tie, Cross(X) wins and Nought(O) wins
 */

public	enum GameState {
	PLAYING, TIE, CROSS_WINS, NOUGHT_WINS;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		switch(this) {
			case CROSS_WINS:{
				builder.append("X");
				break;
			}
			case NOUGHT_WINS:{
				builder.append("O");
				break;
			}
			case TIE:{
				builder.append("Tie");
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