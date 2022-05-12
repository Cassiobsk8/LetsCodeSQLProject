package com.letscode.springmysql;


import com.letscode.springmysql.sql.SQLHandler;

public class SqlApplication
{
	public static void main(String[] args)
	{
		SQLHandler.initiateSQLDatabase();

		GUIHandler.showGUI();
	}
}
