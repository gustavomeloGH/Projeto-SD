package br.com.novaroma.sistemasdistribuidos.AdventureWorks;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tabelas extends javax.swing.JFrame {

    private ArrayList<Integer> produtos;
    private HashMap<Integer, ArrayList> produtosStatus;
    private DefaultTableModel tableJProdutos;
    private DefaultTableModel tableJStatus;
    private IAdventureWorks adventureWorks;

   
    public Tabelas() {
        initComponents();
        produtos = new ArrayList<>();
        produtosStatus = new HashMap();
        initializeArrayProdutos();
        initializeJTables();
        atualizarJTableProdutos();
        atualizarJTableStatus();
    }
    
 
    private void initializeJTables() {
        tableJProdutos = new DefaultTableModel();
        tableJProdutos.addColumn("Codigo");

        tableJStatus = new DefaultTableModel();
        tableJStatus.addColumn("Codigo");
        tableJStatus.addColumn("Status");
        tableJStatus.addColumn("Telefone");

    }

    private void initializeArrayProdutos() {
        Random random = new Random();
        Integer randomNum = 0;
        for (int i = 0; i < 10; i++) {
            randomNum = 1000 + (int) (Math.random() * 100000);
            produtos.add(randomNum);
        }
    }

    private void atualizarJTableProdutos() {
        if (produtos.isEmpty()) {
            tableJProdutos.addRow(new String[]{"Não tem informações"});
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                tableJProdutos.addRow(new String[]{String.valueOf(produtos.get(i)), "Aberto"});
            }
        }
        Tabela1.setModel(tableJProdutos);
    }

    private void atualizarJTableStatus() {
        
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
    
    public void setAdventureWorks(IAdventureWorks adventureWorks) {
        this.adventureWorks  = adventureWorks;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AtualizarProdutos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela1 = new javax.swing.JTable();
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

        Tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Codigo"
            }
        ));
        jScrollPane1.setViewportView(Tabela1);

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
        jScrollPane2.setViewportView(tabela2);

        Atualizar_Situacao.setText("Atualizar");
        Atualizar_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atualizar_SituacaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Produtos");

        jLabel4.setText("Situação do Produto");

        CadastrarProdutos.setText("Cadastrar");

        jLabel5.setBackground(new java.awt.Color(0, 0, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ADVENTURE WORKS ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CadastrarProdutos)
                        .addGap(97, 97, 97)
                        .addComponent(AtualizarProdutos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Atualizar_Situacao)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atualizar_Situacao)
                    .addComponent(AtualizarProdutos)
                    .addComponent(CadastrarProdutos))
                .addContainerGap(40, Short.MAX_VALUE))
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarProdutos;
    private javax.swing.JButton Atualizar_Situacao;
    private javax.swing.JButton CadastrarProdutos;
    private javax.swing.JTable Tabela1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela2;
    // End of variables declaration//GEN-END:variables
}
