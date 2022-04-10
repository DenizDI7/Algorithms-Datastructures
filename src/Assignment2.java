import java.util.Scanner;

public class Assignment2 {
    /**
     * Doubly linked list to use as a data structure declaring a value and the pointers to the elements
     */
    static class Element {
        int value;
        Element prev = null;
        Element next = null;

        public Element(int value) {
            this.value = value;

        }
    }

    //Length of the list and sets the first, last, and mid-pointers of the list
    public static int length = 0;
    public static Element first = null;
    public static Element last = null;
    public static Element mid = null;

    /**
     * Makes a new Element with a value and checks whether the list is empty or not (if it is, it inserts the new element), and if the first char in direction is R or default (L)
     * @param value value of the list: (random number)
     * @param direction character of the list: R/L
     */
    public static void insertElement(int value, String direction) {
        Element newElement = new Element(value);

        if (length == 0) {
            first = newElement;
            last = newElement;
            mid = newElement;
        } else {
            switch (direction.charAt(0)) {
                case 'R':
                    last.next = newElement;
                    newElement.prev = last;
                    last = newElement;
                    if (length % 2 == 0) {
                        mid = mid.next;
                    }
                    break;
                default:
                    first.prev = newElement;
                    newElement.next = first;
                    first = newElement;
                    if (length % 2 == 1) {
                        mid = mid.prev;
                    }
            }
        }
        length++;
    }

    /**
     * Removes the middle value of the list in different cases of the list size: 0, 1, 2, ... - and changes the corrects the next and prev pointers
     * @return returns the middle value after removing it from the list
     */
    public static int removeElement() {
        int returnValue = mid.value;

        switch (length) {
            case 0: //If the list contains 0 elements
                System.out.println("Trying to pop empty list");
                return 0;
            case 1: //If the list contains 1 element: sets the first, last and mid element to null, since theres only one which have been removed
                first = null;
                last = null;
                mid = null;
                break;
            case 2: //If the list contains 2 elements: corrects the pointers
                first = last;
                last.prev = null;
                mid = last;
                break;
            default: //If the list contains more than 3 elements: corrects the pointers
                Element a = mid.prev;
                Element b = mid.next;
                a.next = b;
                b.prev = a;
                if (length % 2 == 0) {
                    mid = b;
                } else {
                    mid = a;
                }
        }
        length--;
        return returnValue;
    }

    /**
     * Takes in the length of the list, and makes a new element given the length of the list, and checks whether there's and E and thereby removes it, otherwise it uses insertElement on the input
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int listLength = s.nextInt();
        s.nextLine();

        for (int i = 0; i < listLength; i++) {
            String command = s.nextLine();
            String[] commandList = command.split(" ");

            if (commandList.length == 1) {
                System.out.println(removeElement());
            } else {
                insertElement(Integer.parseInt(commandList[1]), commandList[0]);
            }
        }
        s.close();
    }
}
