package week9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import week9.coding_assignment.*;
import week9.coding_questions.*;

public class Week9Verification {
    private static void test(String name, Runnable runnable, String input, String expected) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }

        String actual = out.toString().replace("\r\n", "\n").trim();
        String exp = expected.replace("\r\n", "\n").trim();
        if (actual.equals(exp)) {
            System.out.println("PASS: " + name);
        } else {
            System.out.println("FAIL: " + name);
            System.out.println("Expected:\n" + exp);
            System.out.println("Actual:\n" + actual);
        }
    }

    public static void main(String[] args) {
        test("Part A - P1: GardenPlotAreaReport",
            () -> GardenPlotAreaReport.main(new String[0]),
            "3\nCIRCLE Asha 5\nRECTANGLE Ravi 4 6\nTRIANGLE Neha 10 3\n",
            "Asha (CIRCLE): 78.54\nRavi (RECTANGLE): 24.00\nNeha (TRIANGLE): 15.00\nTotal Area: 117.54"
        );

        test("Part A - P2: WeeklyStaffPay",
            () -> WeeklyStaffPay.main(new String[0]),
            "3\nFULLTIME Asha 12000\nHOURLY Ravi 45 200\nINTERN Neha 5000\n",
            "Asha: 12000.00\nRavi: 9500.00\nNeha: 5000.00\nTotal Payroll: 26500.00"
        );

        test("Part A - P3: LibraryLateFineCounter",
            () -> LibraryLateFineCounter.main(new String[0]),
            "3\nBOOK Algebra 4\nDVD Inception 12\nMAGAZINE Sports 3\n",
            "Algebra: 8.00\nInception: 50.00\nSports: 3.00\nTotal Fines: 61.00"
        );

        test("Part A - P4: ElectricityConnectionBilling",
            () -> ElectricityConnectionBilling.main(new String[0]),
            "3\nHOME 150\nSHOP 90\nFACTORY 120\n",
            "HOME: 850.00\nSHOP: 820.00\nFACTORY: 1000.00\nTotal: 2670.00"
        );

        test("Part A - P5: TravelBookingWithCommonFee",
            () -> TravelBookingWithCommonFee.main(new String[0]),
            "3\nBUS 200\nTRAIN 300\nFLIGHT 500\n",
            "BUS: 450.00\nTRAIN: 500.00\nFLIGHT: 4550.00"
        );

        test("Assignment - P1: MovieTicketCounter",
            () -> MovieTicketCounter.main(new String[0]),
            "3\nREGULAR 3\nPREMIUM 2\nRECLINER 1\n",
            "REGULAR: 510.00\nPREMIUM: 540.00\nRECLINER: 420.00\nTotal: 1470.00"
        );

        test("Assignment - P2: ParcelShippingDesk",
            () -> ParcelShippingDesk.main(new String[0]),
            "3\nSTANDARD 3 500\nEXPRESS 2 1000\nFRAGILE 4 2000\n",
            "STANDARD: Charge=70.00 Insurance=0.00 Total=70.00\nEXPRESS: Charge=110.00 Insurance=20.00 Total=130.00\nFRAGILE: Charge=130.00 Insurance=40.00 Total=170.00\nGrand Total: 370.00"
        );

        test("Assignment - P3: CollegeFeeCounter",
            () -> CollegeFeeCounter.main(new String[0]),
            "3\nDAY_SCHOLAR Asha\nHOSTELLER Ravi\nSCHOLAR Neha\n",
            "Asha: 52000.00\nRavi: 100000.00\nNeha: 32000.00\nTotal Collected: 184000.00"
        );

        test("Assignment - P4: CityCabFareMeter",
            () -> CityCabFareMeter.main(new String[0]),
            "4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT\n",
            "MINI: 100.00\nSEDAN: 168.00\nSUV: 360.00\nMINI: night service not available\nTotal: 628.00"
        );

        test("Assignment - P5: HomeApplianceEnergyReport",
            () -> HomeApplianceEnergyReport.main(new String[0]),
            "4\nFRIDGE 24\nAC 8 SAVER\nTV 5\nWASHER 2 SAVER\n",
            "FRIDGE: Units=3.60 Cost=28.80\nAC: Units=9.00 Cost=72.00\nTV: Units=0.50 Cost=4.00\nWASHER: Units=0.75 Cost=6.00\nTotal Cost: 110.80"
        );
    }
}
