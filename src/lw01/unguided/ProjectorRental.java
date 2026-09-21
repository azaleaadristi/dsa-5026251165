package lw01.unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int day = getDays();
        int total;

        if (day <= 3) {
            total = day * 60000;
        } else {
            total = (3 *60000) + ((day - 3) * 45000);
        }

        return total + 20000;
    }

    @Override
    public String label() {
        return "Projector";
    }
}