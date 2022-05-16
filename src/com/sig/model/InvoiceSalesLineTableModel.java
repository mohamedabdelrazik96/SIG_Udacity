
package com.sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceSalesLineTableModel extends AbstractTableModel {

    private ArrayList<InvoicSaleseLine> linesArray;
    private String[] columns = {"Item Name", "Unit Price", "Count", "Line Total"};

    public InvoiceSalesLineTableModel(ArrayList<InvoicSaleseLine> linesArray) {
        this.linesArray = linesArray;
    }

    @Override
    public int getRowCount() {
        return linesArray == null ? 0 : linesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (linesArray == null) {
            return "";
        } else {
            InvoicSaleseLine line = linesArray.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return line.getItem();
                case 1:
                    return line.getPrice();
                case 2:
                    return line.getCount();
                case 3:
                    return line.getLineTotal();
                default:
                    return "";
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
