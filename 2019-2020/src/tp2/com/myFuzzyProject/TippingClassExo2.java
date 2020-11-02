package tp2.com.myFuzzyProject;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class TippingClassExo2 {
	public static void main(String[] args) throws Exception {
		String filename = "exo2.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		fb.setVariable("meteo", 8.5);
		fb.setVariable("prix", 7.5);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("duree").defuzzify();
		
		// Print ruleSet
		System.out.println(fb);
		System.out.println("duree: " + fb.getVariable("duree").getValue());

		JFuzzyChart.get().chart(fb);
	}

}
