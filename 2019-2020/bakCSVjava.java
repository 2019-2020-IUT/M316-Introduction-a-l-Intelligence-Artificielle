package tp2.com.myFuzzyProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class TippingClass {
	public static void main(String[] args) throws Exception {

		String filename = "tipper.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Print ruleSet
		System.out.println(fb);
		System.out.println("Tip: " + fb.getVariable("tip").getValue());
		// System.out.println("");

		try (FileWriter writer = new FileWriter("./result.csv")) {
			for (int f = 0; f < 9; f++) {
				for (int s = 0; s < 18; s++) {
					// Set inputs
					fb.setVariable("food", f);
					fb.setVariable("service", s);

					// Evaluate
					fb.evaluate();

					// Show output variable's chart
					fb.getVariable("tip").defuzzify();
					writer.write(f + ";" + s + ";" + fb.getVariable("tip").defuzzify());
					writer.append(System.lineSeparator());
					writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//JFuzzyChart.get().chart(fb);

	}

}

