
package aula3clienteteste;

import aula3util.IChatAula;
import aula3util.Message;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;

public class ChatTela extends javax.swing.JFrame {

    
    public ChatTela() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DigiteMensagem = new javax.swing.JLabel();
        Mensagem = new javax.swing.JTextField();
        Enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Conversa = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        Chat = new javax.swing.JMenu();
        Sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DigiteMensagem.setText("Digite sua Mensagem: ");

        Mensagem.setText("Mensagem: ");
        Mensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MensagemActionPerformed(evt);
            }
        });

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        Conversa.setColumns(20);
        Conversa.setRows(5);
        jScrollPane1.setViewportView(Conversa);

        Chat.setText("Chat ");

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Chat.add(Sair);

        jMenuBar1.add(Chat);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(DigiteMensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DigiteMensagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(Mensagem)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed

    }//GEN-LAST:event_SairActionPerformed

    private void MensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MensagemActionPerformed
        
    }//GEN-LAST:event_MensagemActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        
        String nome = "";
        String msgp = "";
        
        try {
            while (msgp != "0") {
                msgp = JOptionPane.showInputDialog("Chat - " + nome
                        + " Digite a sua mensagem. (Tecle 0 para Sair!)");
                IChatAula objChat = (IChatAula) Naming
                        .lookup("rmi://localhost:8282/chat");
                Message msg = new Message(nome, msgp);
                objChat.sendMessage(msg);
                System.out.println(returnMessage(objChat.retrieveMessage()));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EnviarActionPerformed
    private static String returnMessage(List<Message> lst) {
        String valor = "";
        for (Message message : lst) {
            valor += message.getUser() + ": " + message.getMessage() + "\n";
        }
        return valor;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Chat;
    private javax.swing.JTextArea Conversa;
    private javax.swing.JLabel DigiteMensagem;
    private javax.swing.JButton Enviar;
    private javax.swing.JTextField Mensagem;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
