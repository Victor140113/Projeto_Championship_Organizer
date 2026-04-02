package dados_controladores;

import javax.swing.ToolTipManager;

public class ControladoresTelas {

	public static void timeToolTipText(int delayAppearMs, int timeShowMs, int timeToReAppear) {
		ToolTipManager toolTip = ToolTipManager.sharedInstance();
		toolTip.setInitialDelay(delayAppearMs);
		toolTip.setDismissDelay(timeShowMs);
		toolTip.setReshowDelay(timeToReAppear);
	}
}
