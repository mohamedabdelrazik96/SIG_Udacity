
package com.sig.model;

import com.sig.view.InvoiceSalesFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceSalesHeaderTableModel extends AbstractTableModel {

    private ArrayList<InvoiceSalesHeaderSales> invoicesArraySales;
    private String[] columns = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    
    public InvoiceSalesHeaderTableModel(ArrayList<InvoiceSalesHeaderSales> invoicesArray) {
        this.invoicesArraySales = invoicesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesArraySales.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceSalesHeaderSales inv = invoicesArraySales.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getNum();
            case 1: return InvoiceSalesFrame.dateFormat.format(inv.getInvDate());
            case 2: return inv.getCustomer();
            case 3: return inv.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
