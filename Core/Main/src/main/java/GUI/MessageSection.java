package GUI;

import dto.MessageDTO;

import javax.swing.*;
import java.awt.*;

public class MessageSection extends JPanel {
    private JLabel messageLabel;
    private MessageDTO messageDTO;

    public MessageSection(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Mensajes"));

        messageLabel = new JLabel("Esperando mensaje...", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);
    }

    public void actualizarMensaje() {
        System.out.println("[DEBUG] Actualizando mensaje en MessageSection: " + messageDTO.getMessage());
        messageLabel.setText("<html>" + messageDTO.getMessage().replace("\n", "<br>") + "</html>");

        // 🔄 Forzar actualización de la UI
        revalidate();
        repaint();
    }
}
