import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import model.SignalConfig;

//
public class EfficientPedestrainCrossing {

	static Map<String, SignalConfig> signals = new LinkedHashMap<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to the system");
		System.out.println("1. Setup Traffic Signal \n2. Test Signal \n" + "3. Manage Traffic Signal \n"
				+ "4. List all Traffic signals" + "5. Exit");
		System.out.println("Please enter your choice");

		while (true) {
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Please enter : epc id , loc , waiting time , " + "no. of pedestrains allowed");

				String epcId = sc.next();
				String locationName = sc.next();
				int waitingTime = sc.nextInt();
				int noOfPedestrainsAllowed = sc.nextInt();
				boolean status = setupTrafficSignal(epcId, locationName, waitingTime, noOfPedestrainsAllowed);
				if (status) {
					System.out.println("Signal Initialized");
				} else {
					System.out.println("Error while initializing");
				}
				break;

			case 2:
				System.out.println("Please : epc id , no. of pedestrains waiting");
				String epcIdTestSignal = sc.next();
				int noOfPedestainsWaiting = sc.nextInt();
				testSignal(epcIdTestSignal, noOfPedestainsWaiting);
				break;

			case 3:
				System.out.println("Enter epc id ");
				String epcIdManageSignal = sc.next();
				System.out.println("1.Delete? \n 2.Change parameters \n Enter your choice: ");
				int manageSignalChoice = sc.nextInt();
				manageSignal(epcIdManageSignal, manageSignalChoice);
				break;

			case 4:
				listSignal();
				break;

			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid");
			}

		}

	}

	private static void listSignal() {
		for (Map.Entry<String, SignalConfig> entry : signals.entrySet()) {
			System.out.println("epc id :" + entry.getKey() + "Details: " + entry.getValue());
		}
	}

	private static void manageSignal(String epcId, int manageSignalChoice) {

		switch (manageSignalChoice) {
		case 1:
			signals.remove(epcId);
			System.out.println("Signal Removed");
			break;
		case 2:
			System.out.println("Enter new values for Waiting time and No of pedestrains");
			int waitingTime = sc.nextInt();
			int noOfPedestrains = sc.nextInt();
			SignalConfig epc = signals.get(epcId);
			epc.setNoOfPedestrainsAllowed(noOfPedestrains);
			epc.setWaitingPeriod(waitingTime);
			signals.put(epcId, epc);
			System.out.println("Values updated");

		default:
			break;
		}

	}

	private static void testSignal(String epcId, int noOfPedestainsWaiting) {
		SignalConfig epc = signals.get(epcId);
		int threshold = getThreshold(epcId, noOfPedestainsWaiting);
		// boolean canCross = false;
		while (noOfPedestainsWaiting > 0) {
			for (int i = 1; i <= threshold; i++) {
				System.out.print(". ");
			}

			System.out.print("Cross Now, " + (noOfPedestainsWaiting - epc.getNoOfPedestrainsAllowed()) + " remaining");
			noOfPedestainsWaiting = noOfPedestainsWaiting - epc.getNoOfPedestrainsAllowed();
			if (noOfPedestainsWaiting > 0) {
				threshold = getThreshold(epcId, noOfPedestainsWaiting);
			}

		}

	}

	private static int getThreshold(String epcId, int noOfPedestainsWaiting) {

		SignalConfig epc = signals.get(epcId);

		int threshold = epc.getWaitingPeriod() / noOfPedestainsWaiting;
		return threshold;
	}

	private static boolean setupTrafficSignal(String epcId, String locationName, int waitingTime,
			int noOfPedestrainsAllowed) {

		SignalConfig newSignal = new SignalConfig(epcId, locationName, waitingTime, noOfPedestrainsAllowed);

		signals.put(epcId, newSignal);

		return true;

	}

}
