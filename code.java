import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class VotingSystem {
    private Map<String, Integer> candidates;
    private int totalVotes;

    public VotingSystem() {
        candidates = new HashMap<>();
        totalVotes = 0;
    }

    public void addCandidate(String candidateName) {
        candidates.put(candidateName, 0);
        System.out.println(candidateName + " has been added to the ballot.");
    }

    public void castVote(String voterId, String candidateName) {
        if (candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1);
            totalVotes++;
            System.out.println("Vote successfully cast by " + voterId);
        } else {
            System.out.println("Invalid candidate. Vote not counted.");
        }
    }

    public void displayResults() {
        System.out.println("\nElection Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
        System.out.println("Total votes cast: " + totalVotes);
    }

    public boolean isValidVoter(String voterId) {
        // Simple check to simulate voter verification, in real applications this would be more complex.
        return voterId.matches("[A-Za-z0-9]+");
    }

    public void runElection() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nElectronic Voting System");
            System.out.println("1. Add Candidate");
            System.out.println("2. Cast Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidateName = scanner.nextLine();
                    addCandidate(candidateName);
                    break;
                case 2:
                    System.out.print("Enter voter ID: ");
                    String voterId = scanner.nextLine();
                    if (isValidVoter(voterId)) {
                        System.out.print("Enter candidate name: ");
                        String voteFor = scanner.nextLine();
                        castVote(voterId, voteFor);
                    } else {
                        System.out.println("Invalid voter ID. Vote not counted.");
                    }
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    System.out.println("Exiting the voting system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

public class VotingApp {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.runElection();
    }
}
