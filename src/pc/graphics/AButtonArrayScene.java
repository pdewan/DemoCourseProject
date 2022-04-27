package pc.graphics;

import util.annotations.Column;
import util.annotations.ComponentWidth;
import util.annotations.Row;

public class AButtonArrayScene extends AProducerConsumerScene {

	
	@Row(0)
	@Column(3)
	@ComponentWidth(100)
	public void chefToTable(Head aHead) {
		super.chefToTable(aHead);
	}
	
	@Row(0)
	@Column(2)
	@ComponentWidth(100)
	public void initScene(int patronAmount, int chefAmount) {
		super.initScene(patronAmount, chefAmount);
	}
}
