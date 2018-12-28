/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.BookDAO;
import model.Borrower;
import control.BorrowerDAO;
import control.LoanDAO;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JO;
import model.Book;
import model.Loan;

/**
 *
 * @author lienb
 */
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    private ServerSocket listener;
    private static Client client;
    DefaultTableModel modelBook;
    DefaultTableModel modelHoldRequest;
    static Borrower  borrower1;
    private ArrayList<Book> bookList;
    private ArrayList<Borrower> borrowerList;
    private ArrayList<Loan> loanList;
    BookDAO bookDAO = new BookDAO();
    BorrowerDAO borrowerDAO = new BorrowerDAO();
    LoanDAO loanDAO = new LoanDAO();
    
    public User(){
        initComponents();
    }
    public User(Client client, Borrower  borrower) {
        
        initComponents();
        this.client = client;
        borrower1 = borrower;
        System.out.println("name" + borrower.getName());
        txtName.setText(borrower.getName());
        txtEmail.setText(borrower.getEmail());
        txtPassword.setText(borrower.getPassword());
        txtAddress.setText(borrower.getAddress());
        txtPhone.setText(String.valueOf(borrower.getPhone()));
        
        bookList = null;
        modelBook = (DefaultTableModel)bookTable.getModel();
        modelHoldRequest = (DefaultTableModel)holdRequestTable.getModel();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSearchBook = new javax.swing.JTextField();
        buttonSearchBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        buttonShowBook = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdBook = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIdBorrower = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        buttonBorrowedBook = new javax.swing.JButton();
        txtissuedDate = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        holdRequestTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        buttonShowHoldRequest = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        buttonUpdate = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Tìm kiếm");

        buttonSearchBook.setText("Tìm");
        buttonSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchBookActionPerformed(evt);
            }
        });

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả"
            }
        ));
        jScrollPane1.setViewportView(bookTable);

        jLabel8.setText("Hiển thị tất cả các sách");

        buttonShowBook.setText("Hiển thị");
        buttonShowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowBookActionPerformed(evt);
            }
        });

        jLabel9.setText("Phiếu mượn sách");

        jLabel10.setText("Mã sách");

        jLabel11.setText("Mã bạn đọc");

        jLabel12.setText("Ngày mượn");

        buttonBorrowedBook.setText("Mượn sách");
        buttonBorrowedBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrowedBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7)
                        .addGap(41, 41, 41)
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonSearchBook))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(buttonShowBook))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdBook)
                                    .addComponent(txtIdBorrower, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtissuedDate)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(buttonBorrowedBook)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearchBook))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(buttonShowBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIdBorrower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtissuedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBorrowedBook)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thư viện", jPanel1);

        holdRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã bạn đọc", "Mã sách", "Ngày yêu cầu"
            }
        ));
        jScrollPane2.setViewportView(holdRequestTable);

        jLabel14.setText("Hiển thị tất cả các yêu cầu mượn sách");

        buttonShowHoldRequest.setText("Hiển thị");
        buttonShowHoldRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowHoldRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)
                        .addComponent(buttonShowHoldRequest))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(buttonShowHoldRequest))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Các yêu cầu mượn sách", jPanel3);

        jLabel1.setText("Họ và tên");

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Số điện thoại");

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        jLabel13.setText("Mã bạn đọc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(buttonUpdate)
                .addGap(248, 248, 248))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonUpdate)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lí thông tin cá nhân", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        try {                                                   
            
            // TODO add your handling code here:
            // Gửi yêu cầu mượn sách
            String request = null;
            try {
                client.sendMSG("updateaccount");
                System.out.println("Gửi updateaccount đến server");
                
                String name = txtName.getText();
                String email = txtEmail.getText();
                String password = txtPassword.getText();
                String address = txtAddress.getText();
                String phone = txtPhone.getText();
                 
                client.sendUpdateAccount(borrower1.getIdPerson(),name, email, password, address, phone);
                
                
            } catch (IOException ex) {
                System.out.println("Lỗi gửi holdRequest đến Server");
                
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            request = client.getMSG();
            
            if(request.equals("updatefail")){
                JOptionPane.showMessageDialog(null, "Yêu cầu thất bại");
            }
            
            if( request.equals("updatesuccess")){
                JOptionPane.showMessageDialog(null, "Yêu cầu thành công");
            }
                
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchBookActionPerformed
        // TODO add your handling code here:
        
        String keyWordBook = txtSearchBook.getText();
        System.out.println(keyWordBook);
        bookList = bookDAO.searchBooksByKeyword(keyWordBook);
        for ( Book book: bookList){
            System.out.println(book.getIdbook()+ " " + book.getTitle());
        }
        showBook(bookList);
        bookList.clear();
    }//GEN-LAST:event_buttonSearchBookActionPerformed

    private void buttonShowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowBookActionPerformed
        try {
            client.sendMSG("showBook");
            System.out.println("Gửi showBook đến server");
        } catch (IOException ex) {
            System.out.println("Lỗi gửi showBook đến Server");
                    
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String request = null;
        int idbook;
        String title;
        String subject;
        String author;
        int quantitySum;
        int quantityBorrowed;
        String status;
        
        modelBook.setRowCount(0);
        while ( true){
            try {
                request = client.getMSG();
                
                if( request.equals("done")){
                    break;
                }
                if(request.equals("book")){
                    
                    idbook = Integer.parseInt(client.getMSG());
                    title = client.getMSG();
                    subject = client.getMSG();
                    author = client.getMSG();
                    quantitySum = Integer.parseInt(client.getMSG());
                    quantityBorrowed = Integer.parseInt(client.getMSG());
                    status = client.getMSG();
                 
                    modelBook.addRow(new Object[]{
                        idbook, title, subject, author
                    });
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       

        
    }//GEN-LAST:event_buttonShowBookActionPerformed

    private void buttonBorrowedBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrowedBookActionPerformed

        try {                                                   
            
            // TODO add your handling code here:
            // Gửi yêu cầu mượn sách
            String request = null;
            try {
                client.sendMSG("holdRequest");
                System.out.println("Gửi holdRequest đến server");
                
              
                String idbook = txtIdBook.getText();
                String idborrower = txtIdBorrower.getText();
                String date = txtissuedDate.getText();
                
                System.out.println("idborrower " + idborrower);
                System.out.println("idbook " + idbook);
                System.out.println("requestdate " + date);
                client.sendHoldRequest(idborrower, idbook, date);
            } catch (IOException ex) {
                System.out.println("Lỗi gửi holdRequest đến Server");
                
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            request = client.getMSG();
            
            if(request.equals("holdfail")){
                JOptionPane.showMessageDialog(null, "Yêu cầu thất bại");
            }
            
            if( request.equals("holdsuccess")){
                JOptionPane.showMessageDialog(null, "Yêu cầu thành công");
            }
                
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            

       

                                                  

                                              
    
        
    }//GEN-LAST:event_buttonBorrowedBookActionPerformed

    private void buttonShowHoldRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowHoldRequestActionPerformed
        // TODO add your handling code here:
        // Hiển thị tất cả các yêu cầu mượn sách của bạn đọc
        
        try {
            client.sendMSG("showrequest");
            System.out.println("Gửi show hold request đến server");
            client.sendMSG(String.valueOf(borrower1.getIdPerson()));
        } catch (IOException ex) {
            System.out.println("Lỗi gửi showBook đến Server");
                    
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String request = null;
        int idborrower;
        int idbook;
        Date requestDate;
                
        modelHoldRequest.setRowCount(0);
        while ( true){
            try {
                request = client.getMSG();
                
                if( request.equals("done")){
                    break;
                }
                if(request.equals("holdrequest")){
                    idborrower = Integer.parseInt(client.getMSG());
                    idbook = Integer.parseInt(client.getMSG());
                    requestDate = Date.valueOf(client.getMSG());
                  
                    modelHoldRequest.addRow(new Object[]{
                        idborrower, idbook, requestDate
                    });
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       

        
        
        
        
        
        
    }//GEN-LAST:event_buttonShowHoldRequestActionPerformed
    
    public void showBook(ArrayList<Book> bookList){
        //model.setRowCount(0);
        /*
        bookTable.setModel( new DefaultTableModel(null, new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số lượng","Đã mượn", "Trạng thái"
            }));
        
        modelBook =( DefaultTableModel) bookTable.getModel();
        modelBook.setRowCount(0);
        */
        modelBook.setRowCount(0);
        System.out.println("show Book được gọi");
        int i = 0;
        for ( Book book: bookList){
            System.out.println("i" + (i++));
            int rows = modelBook.getRowCount(); 
            System.out.println("rows: " + rows);
            modelBook.addRow(new Object[]{
                book.getIdbook(), book.getTitle(), book.getSubject(), book.getAuthor()
            });
        }
                    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Borrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User(client, borrower1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JButton buttonBorrowedBook;
    private javax.swing.JButton buttonSearchBook;
    private javax.swing.JButton buttonShowBook;
    private javax.swing.JButton buttonShowHoldRequest;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTable holdRequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdBook;
    private javax.swing.JTextField txtIdBorrower;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtissuedDate;
    // End of variables declaration//GEN-END:variables
}