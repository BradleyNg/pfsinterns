import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EmailClient extends JFrame {

    private List<Email> inbox = new ArrayList<>();

    private JTextArea inboxArea;
    private JTextField recipientField;
    private JTextField subjectField;
    private JTextArea bodyArea;

    public EmailClient() {
        setTitle("Simple Email Client");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left side for inbox display
        inboxArea = new JTextArea();
        inboxArea.setEditable(false);
        JScrollPane inboxScrollPane = new JScrollPane(inboxArea);
        inboxScrollPane.setPreferredSize(new Dimension(300, 400));
        add(inboxScrollPane, BorderLayout.WEST);

        // Right side for composing emails
        JPanel composePanel = new JPanel();
        composePanel.setLayout(new GridLayout(5, 1));

        // Recipient
        recipientField = new JTextField();
        composePanel.add(new JLabel("Recipient:"));
        composePanel.add(recipientField);

        // Subject
        subjectField = new JTextField();
        composePanel.add(new JLabel("Subject:"));
        composePanel.add(subjectField);

        // Body
        bodyArea = new JTextArea(5, 20);
        JScrollPane bodyScrollPane = new JScrollPane(bodyArea);
        composePanel.add(new JLabel("Body:"));
        composePanel.add(bodyScrollPane);

        add(composePanel, BorderLayout.CENTER);

        // Bottom panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton sendButton = new JButton("Send");
        JButton refreshButton = new JButton("Refresh Inbox");
        buttonPanel.add(sendButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener to send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });

        // Add action listener to refresh button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshInbox();
            }
        });
    }

    // Method to simulate sending an email
    private void sendEmail() {
        String recipient = recipientField.getText();
        String subject = subjectField.getText();
        String body = bodyArea.getText();

        if (recipient.isEmpty() || subject.isEmpty() || body.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Email email = new Email(recipient, subject, body);
            inbox.add(email);  // Add the email to inbox (simulated)
            JOptionPane.showMessageDialog(this, "Email sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
    }

    // Method to clear email fields after sending
    private void clearFields() {
        recipientField.setText("");
        subjectField.setText("");
        bodyArea.setText("");
    }

    // Method to refresh inbox and display emails
    private void refreshInbox() {
        inboxArea.setText("");  // Clear the inbox area
        if (inbox.isEmpty()) {
            inboxArea.setText("No emails in inbox.");
        } else {
            for (Email email : inbox) {
                inboxArea.append("To: " + email.getRecipient() + "\n");
                inboxArea.append("Subject: " + email.getSubject() + "\n");
                inboxArea.append("Body: \n" + email.getBody() + "\n\n");
                inboxArea.append("---------------------------------------------\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailClient emailClient = new EmailClient();
            emailClient.setVisible(true);
        });
    }
}



