package com.letscode.springmysql.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class SQLHandler
{
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DATABASE = "crm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin8808admin";

    public static final String VENDAS_CLIENTES = "select e.empresa, SUM(v.valorNegociado) as TotalDeVendas from vendas as v join infoempresa as e on e.id = v.idEmpresa group by e.empresa order by SUM(v.valorNegociado) desc";
    public static final String VENDAS_RECORRENTE = "select e.empresa, SUM(v.valorNegociado) as TotalDeVendasRecorrente from vendas as v join infoempresa as e on e.id = v.idEmpresa where v.tipocompra like '%SERVIÇOS RECORRENTES%' group by e.empresa order by SUM(v.valorNegociado) desc";
    public static final String VENDAS_POR_UF = "select e.uf, SUM(v.valorNegociado) as TotalDeVendas from vendas as v join infoempresa as e on e.id = v.idEmpresa group by e.uf order by SUM(v.valorNegociado) desc";


    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
    }

    public static ResultSet executeSQL(String sql)
    {
        ResultSet resultSet = null;
        try
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void initiateSQLDatabase()
    {
        File file = new File("src/main/resources/sql/data.sql");
        String delimiter = ";";
        Scanner scanner;
        try
        {
            scanner = new Scanner(file).useDelimiter(delimiter);
        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
            return;
        }
        Statement currentStatement = null;
        while (scanner.hasNext())
        {
            String rawStatement = scanner.next() + delimiter;
            try
            {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                currentStatement = connection.createStatement();
                currentStatement.execute(rawStatement);
            } catch (SQLException e)
            {
                e.printStackTrace();
            } finally
            {
                if (currentStatement != null)
                {
                    try
                    {
                        currentStatement.close();
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                currentStatement = null;
            }
        }
        scanner.close();
    }
}
