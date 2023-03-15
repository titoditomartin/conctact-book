import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\t" + phone + "\t" + email;
    }
}

public class Main {
    static LinkedList<Contact> contacts = new LinkedList<Contact>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("************\n(A)dd \n(D)elete \n(E)mail Search \n(P)rint List \n(S)earch \n(Q)uit");
            System.out.print("************\nEnter your choice: ");
            choice = sc.next().charAt(0);
            sc.nextLine(); // consume the newline character

            switch (choice) {
                case 'A':
                    addContact(sc);
                    break;
                case 'D':
                    deleteContact(sc);
                    break;
                case 'E':
                    emailSearch(sc);
                    break;
                case 'P':
                    printList();
                    break;
                case 'S':
                    search(sc);
                    break;
                case 'Q':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 'Q');

        sc.close();
    }

    public static void addContact(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added.");
    }

    public static void deleteContact(Scanner sc) {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        boolean removed = false;
        Iterator<Contact> iter = contacts.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            if (contact.name.equals(name)) {
                iter.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void emailSearch(Scanner sc) {
        System.out.print("Enter email to search: ");
        String email = sc.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.email.equals(email)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void printList() {
        if (contacts.size() == 0) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Name\tPhone\tEmail");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void search(Scanner sc) {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.equals(name)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }

        if (!found) ;
    }
}
