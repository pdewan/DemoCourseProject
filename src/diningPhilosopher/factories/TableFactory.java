package diningPhilosopher.factories;

import graphics.Table;
import graphics.TableInterface;

// scode //
public class TableFactory {

		static TableInterface table;

		public static TableInterface getTable() {
			if (table == null) {
				table = 
						new Table(400, 200, 300, 300);

			}
			return table;

		}
}
