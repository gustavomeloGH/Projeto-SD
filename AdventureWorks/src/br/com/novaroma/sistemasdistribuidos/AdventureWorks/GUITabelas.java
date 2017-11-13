package br.com.novaroma.sistemasdistribuidos.AdventureWorks;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class GUITabelas extends javax.swing.JFrame {

    private ArrayList<Integer> produtos;
    private HashMap<Integer, ArrayList> produtosStatus;
    private DefaultTableModel tableJProdutos;
    private DefaultTableModel tableJStatus;
    private IAdventureWorks adventureWorks;

    public GUITabelas() {
    }

    public GUITabelas(IAdventureWorks adventureWorks) {
        initComponents();
        alterarLayout();
        this.adventureWorks = adventureWorks;
        produtos = new ArrayList<>();
        initializeJTables();
        initializeArrayProdutos();
        atualizarJTableProdutos();
        atualizarJTableStatus();
    }

    private void initializeJTables() {
        tableJProdutos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableJProdutos.addColumn("Codigo");

        tableJStatus = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableJStatus.addColumn("Codigo");
        tableJStatus.addColumn("Status");
        tableJStatus.addColumn("Telefone");
    }

    private void initializeArrayProdutos() {
        Random random = new Random();
        Integer randomNum;

        for (int i = 0; i < 10; i++) {
            randomNum = 1000 + (int) (Math.random() * 100000);
            produtos.add(randomNum);
        }
    }

    private void atualizarJTableProdutos() {
        tableJProdutos.setRowCount(0);
        if (produtos.isEmpty()) {
            tableJProdutos.addRow(new String[]{"Não tem informações"});
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                tableJProdutos.addRow(new String[]{String.valueOf(produtos.get(i)), "Aberto"});
            }
        }
        tabela1.setModel(tableJProdutos);

    }

    private void atualizarJTableStatus() {
        tableJStatus.setRowCount(0);
        try {
            produtosStatus = adventureWorks.listRequest();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        if (produtosStatus.isEmpty()) {
            tableJStatus.addRow(new String[]{"Não tem informações", "Sem informações", "Sem informações"});
        } else {
            produtosStatus.entrySet().forEach((entry) -> {
                Integer key = entry.getKey();
                ArrayList value = entry.getValue();
                tableJProdutos.addRow(new String[]{String.valueOf(key), "Aberto", value.get(1).toString()});
            });
        }
        tabela2.setModel(tableJStatus);
    }

    private void alterarLayout() {
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AtualizarProdutos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        Atualizar_Situacao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CadastrarProdutos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        AtualizarProdutos.setText("Atualizar");
        AtualizarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarProdutosActionPerformed(evt);
            }
        });

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela1);

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Status", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela2.setEnabled(false);
        jScrollPane2.setViewportView(tabela2);

        Atualizar_Situacao.setText("Atualizar");
        Atualizar_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atualizar_SituacaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Produtos");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Situação do Produto");

        CadastrarProdutos.setText("Cadastrar");
        CadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarProdutosActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADVENTURE WORKS ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(205, 205, 205))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(CadastrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AtualizarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Atualizar_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atualizar_Situacao)
                    .addComponent(AtualizarProdutos)
                    .addComponent(CadastrarProdutos))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void AtualizarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarProdutosActionPerformed
        atualizarJTableProdutos();

    }//GEN-LAST:event_AtualizarProdutosActionPerformed

    private void Atualizar_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atualizar_SituacaoActionPerformed
        atualizarJTableStatus();
    }//GEN-LAST:event_Atualizar_SituacaoActionPerformed

    private void CadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarProdutosActionPerformed
        String id = JOptionPane.showInputDialog("Informe o ID que deseja abrir o processo: ");
        
        if (id != null) {
            if (this.produtos.contains(id)) {
                
                String phone = JOptionPane.showInputDialog("Para completar a requisição, digite seu número de telefone: ");
               
                if (phone != null) {
                    try {
                        adventureWorks.sendRequest(Integer.parseInt(id), phone);
                        produtos.remove(id);
                    } catch (RemoteException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                
            } else {
                 JOptionPane.showMessageDialog(null, "Esse ID não existe na lista, por gentileza tente novamente!");
            }
        }


    }//GEN-LAST:event_CadastrarProdutosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GUITabelas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarProdutos;
    private javax.swing.JButton Atualizar_Situacao;
    private javax.swing.JButton CadastrarProdutos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela1;
    private javax.swing.JTable tabela2;
    // End of variables declaration//GEN-END:variables
}
