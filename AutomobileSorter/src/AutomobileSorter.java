import java.util.*;
/* Dusting off my Java programming skills */

class AutomobileSorter {
    public enum Order {
        Name,
        Price,
        MPG
    };

    static List<Automobile> sort(final Collection<Automobile> autos, final String sortBy, final Boolean asc) throws Exception {
        if (sortBy.equals("name")) {
            return sort(autos, Order.Name, asc);
        } else if (sortBy.equals("price")) {
            return sort(autos, Order.Price, asc);
        } else if (sortBy.equals("milesPerGallon")) {
            return sort(autos, Order.MPG, asc);
        } else {
            throw new Exception("Unknown sort order");
        }
    }

    static List<Automobile> sort(final Collection<Automobile> autos, final Order sortBy, final Boolean asc) {
        List<Automobile> sortedList = new ArrayList<Automobile>(autos);

        switch (sortBy) {
            case Name:
                Collections.sort(sortedList, new NameComparator(!asc));
                break;
            case Price:
                Collections.sort(sortedList, new PriceComparator(!asc));
                break;
            case MPG:
                Collections.sort(sortedList, new MpgComparator(!asc));
                break;
        }

        return sortedList;
    }

}

class NameComparator implements Comparator<Automobile> {
    boolean reverse;

    NameComparator() {
        reverse = false;
    }

    NameComparator(Boolean reversed) {
        reverse = reversed;
    }

    @Override
    public int compare(Automobile auto1, Automobile auto2) {
        if (reverse) {
            return auto2.name.compareTo(auto1.name);
        } else {
            return auto1.name.compareTo(auto2.name);
        }
    }
}

class PriceComparator implements Comparator<Automobile> {
    boolean reverse;

    PriceComparator() {
        reverse = false;
    }

    PriceComparator(Boolean reversed) {
        reverse = reversed;
    }

    @Override
    public int compare(Automobile auto1, Automobile auto2) {
        if (reverse) {
            return auto2.price.compareTo(auto1.price);
        } else {
            return auto1.price.compareTo(auto2.price);
        }
    }
}

class MpgComparator implements Comparator<Automobile> {
    boolean reverse;

    MpgComparator() {
        reverse = false;
    }

    MpgComparator(Boolean reversed) {
        reverse = reversed;
    }

    @Override
    public int compare(Automobile auto1, Automobile auto2) {
        if (reverse) {
            return auto2.milesPerGallon.compareTo(auto1.milesPerGallon);
        } else {
            return auto1.milesPerGallon.compareTo(auto2.milesPerGallon);
        }
    }
}