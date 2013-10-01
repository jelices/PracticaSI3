package modelo;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class BaseDatos {

	private final static String servidor="127.0.0.1"; 
	private final static String login="si3_144";
	public static Usuario comprobarLogin(String userName, String password)
	{
		Usuario user=new Usuario();
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();

			Statement statement=connection.createStatement();
			/*ResultSet rs = statement.executeQuery("select * from INFORMATION_SCHEMA.columns where table_name='usuarios';");
			rs.first();
			sesion.setAttribute("error", rs.getObject(2)+"   "+rs.getObject(2)+"  "+rs.getObject(3));
			*/
			if(!userName.equals("root"))
			{
				ResultSet rs = statement.executeQuery("SELECT * FROM usuarios, usuariosregistrados WHERE id=nombre AND id='" + userName +"' AND password='"+password+"'");
				if(rs.first())
				{
					user.setNombre(userName);
					user.setNif((String)rs.getObject("nif"));
					user.setNombreEmpresa((String)rs.getObject("nombreEmpresa"));
					user.setSedeSocial((String)rs.getObject("sedeSocial"));
					user.setTelefono((String)rs.getObject("telefono"));
					user.setEmail((String)rs.getObject("email"));
					user.setNombreContacto((String)rs.getObject("nombreContacto"));
					user.setApellidosContacto((String)rs.getObject("apellidosContacto"));
					user.setCategoriaEmpresa((String)rs.getObject("categoriaEmpresa"));
					user.setTipoActividad((String)rs.getObject("tipoActividad"));
					user.setSubcategoria((String)rs.getObject("subcategoria"));
					user.setInforme((String)rs.getObject("informe"));
					user.setFormato((String)rs.getObject("formato"));
					user.setCatSubvenciones((String)rs.getObject("catSubvenciones"));
					user.registrado();
				}
			}
			else
			{
				ResultSet rs = statement.executeQuery("SELECT * FROM usuarios WHERE id='" + userName +"' AND password='"+password+"'");
				if(rs.first())
				{
					user.setNombre(userName);
					user.administrador();
				}
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return user;
	}
	
	public static boolean existeLogin(String userName)
	{
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();

			Statement statement=connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios WHERE id='" + userName +"'");
			return rs.first();
		}
		catch(SQLException e){e.printStackTrace();}
		return false;
	}
	
	public static boolean guardarUsuario(Usuario user, String password) 
	{
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL ="INSERT INTO usuarios values('" + user.getNombre() + "', '" + password + "', " + false +");";
			st1.executeUpdate(SQL);
			Statement st2 = connection.createStatement();
			String SQL2 ="INSERT INTO usuariosregistrados values('" + user.getNombre() + "', '" + user.getNif() + "', '" + user.getNombreEmpresa() + "', '" + user.getSedeSocial() + "', '" + user.getTelefono() + "', '" + user.getEmail() + "', '" + user.getNombreContacto() + "', '" + user.getApellidosContacto() + "', '" + user.getCategoriaEmpresa() + "', '" + user.getTipoActividad() + "', '" + user.getSubcategoria() + "', '" + user.getInforme() + "', '" + user.getFormato() + "', '" + user.getCatSubvenciones() + "');";
			st2.executeUpdate(SQL2);
			connection.commit();
			connection.setAutoCommit(true);
			if((st1.getUpdateCount()>0)&&(st2.getUpdateCount()>0))
				return true;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}

		return false;
	}
	
	public static boolean cambiarPassword(String userName, String passwordNuevo) 
	{
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			Statement st1 = connection.createStatement();
			String SQL ="UPDATE usuarios SET password='" +passwordNuevo +"' WHERE id='" +userName +"';";
			st1.executeUpdate(SQL);
			if(st1.getUpdateCount()>0)
				return true;
			return false;
		} catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	}
	
	public static boolean modificarUsuario(Usuario user) 
	{
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL ="DELETE FROM usuariosregistrados WHERE nombre='"+user.getNombre()+"';";
			st1.executeUpdate(SQL);
			Statement st2 = connection.createStatement();
			String SQL2 ="INSERT INTO usuariosregistrados values('" + user.getNombre() + "', '" + user.getNif() + "', '" + user.getNombreEmpresa() + "', '" + user.getSedeSocial() + "', '" + user.getTelefono() + "', '" + user.getEmail() + "', '" + user.getNombreContacto() + "', '" + user.getApellidosContacto() + "', '" + user.getCategoriaEmpresa() + "', '" + user.getTipoActividad() + "', '" + user.getSubcategoria() + "', '" + user.getInforme() + "', '" + user.getFormato() + "', '" + user.getCatSubvenciones() + "');";
			st2.executeUpdate(SQL2);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}

		return true;
	}
	
	public static ArrayList<Usuario> getListaUsuarios()
	{
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM  usuariosregistrados;");
			while(rs.next())
			{
				Usuario user=new Usuario();
				user.setNombre((String)rs.getObject("nombre"));
				user.setNif((String)rs.getObject("nif"));
				user.setNombreEmpresa((String)rs.getObject("nombreEmpresa"));
				user.setSedeSocial((String)rs.getObject("sedeSocial"));
				user.setTelefono((String)rs.getObject("telefono"));
				user.setEmail((String)rs.getObject("email"));
				user.setNombreContacto((String)rs.getObject("nombreContacto"));
				user.setApellidosContacto((String)rs.getObject("apellidosContacto"));
				user.setCategoriaEmpresa((String)rs.getObject("categoriaEmpresa"));
				user.setTipoActividad((String)rs.getObject("tipoActividad"));
				user.setSubcategoria((String)rs.getObject("subcategoria"));
				user.setInforme((String)rs.getObject("informe"));
				user.setFormato((String)rs.getObject("formato"));
				user.setCatSubvenciones((String)rs.getObject("catSubvenciones"));
				user.registrado();
				usuarios.add(user);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return usuarios;
	}
	
	public static boolean borrarUsuario(Usuario user)
	{
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL= "DELETE FROM usuariosregistrados WHERE nombre='"+user.getNombre()+"';";
			st1.executeUpdate(SQL);
			Statement st2 = connection.createStatement();
			String SQL2 ="DELETE FROM usuarios WHERE id='"+user.getNombre()+"';";
			st2.executeUpdate(SQL2);
			connection.commit();
			connection.setAutoCommit(true);
			if((st1.getUpdateCount()>0)&&(st2.getUpdateCount()>0))
				return true;
			return false;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}
			
	}
	
	public static boolean guardarSubvencion(Subvencion subvencion) 
	{
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL ="INSERT INTO subvenciones(titulo,categoria,condiciones,ambito,objeto,lugar,nueva) values('" + subvencion.getTitulo() + "', '" + subvencion.getCategoria() + "', '"+subvencion.getCondiciones() + "', '"+subvencion.getAmbito() + "', '"+subvencion.getObjeto()+ "', '"+subvencion.getLugar() +"', "+true+");";
			st1.executeUpdate(SQL);
			Statement statement=connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM  subvenciones WHERE titulo='"+subvencion.getTitulo() +"';");
			while(rs.next())
			{
				//(titulo,categoria,condiciones,ambito,objeto,lugar)
				if((subvencion.getCategoria().equals((String)rs.getObject("categoria")))&&(subvencion.getCondiciones().equals((String)rs.getObject("condiciones")))&&(subvencion.getObjeto().equals((String)rs.getObject("objeto")))&&(subvencion.getAmbito().equals((String)rs.getObject("ambito")))&&(subvencion.getLugar().equals((String)rs.getObject("lugar"))))	
				{
					subvencion.setId((Integer)rs.getObject("id"));
					if((st1.getUpdateCount()>0))
					{
						connection.commit();
						connection.setAutoCommit(true);
						return true;
					}
				}
			}
			connection.rollback();
			return false;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}
	}
	
	public static ArrayList<Subvencion> getListaSubvenciones()
	{
		ArrayList<Subvencion> subvenciones=new ArrayList<Subvencion>();
		
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM  subvenciones;");
			while(rs.next())
			{
				//(titulo,categoria,condiciones,ambito,objeto,lugar)
				Subvencion subvencion=new Subvencion();
				subvencion.setTitulo((String)rs.getObject("titulo"));
				subvencion.setCategoria((String)rs.getObject("categoria"));
				subvencion.setCondiciones((String)rs.getObject("condiciones"));
				subvencion.setAmbito((String)rs.getObject("ambito"));
				subvencion.setObjeto((String)rs.getObject("objeto"));
				subvencion.setLugar((String)rs.getObject("lugar"));
				subvencion.setId((Integer)rs.getObject("id"));
				subvenciones.add(subvencion);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return subvenciones;
	}

	public static boolean borrarSubvencion(Subvencion s) {
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL= "DELETE FROM subvenciones WHERE id='"+s.getId()+"';";
			st1.executeUpdate(SQL);
			connection.commit();
			connection.setAutoCommit(true);
			if((st1.getUpdateCount()>0))
				return true;
			return false;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}
	}

	public static boolean modificarSubvencion(Subvencion s) {
		MysqlDataSource ds=new MysqlDataSource();
		Connection connection=null;
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL ="UPDATE subvenciones SET titulo='"+s.getTitulo()+"', categoria='" +s.getCategoria()+"', condiciones='" +s.getCondiciones() +"', ambito='" +s.getAmbito() +"', objeto='" +s.getObjeto() +"', lugar='" +s.getLugar() +"', nueva=" +true +" WHERE id='"+s.getId()+"';";
			st1.executeUpdate(SQL);
			connection.commit();
			connection.setAutoCommit(true);
			if(st1.getUpdateCount()>0)
				return true;
			return false;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}
	}
	
	public static ArrayList<Subvencion> busquedaSubvenciones(String[] titulo, String categoria, String ambito, String lugar)
	{
		ArrayList<Subvencion> busqueda=new ArrayList<Subvencion>();
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();
			Statement statement=connection.createStatement();
			String SQL ="SELECT * FROM  subvenciones WHERE titulo LIKE '%'";
			for(int i=0; i<titulo.length; i++)
				SQL =SQL+" AND titulo LIKE '%" +titulo[i].trim()+"%'";
			if(!categoria.equals("0"))
				SQL =SQL+" AND categoria = '" +categoria+"'";
			if(!ambito.equals("0"))
				SQL =SQL+" AND ambito = '" +ambito+"'";
			if(ambito.equals("3")||ambito.equals("4"))
				SQL =SQL+" AND lugar = '" +lugar+"'";
			ResultSet rs = statement.executeQuery(SQL+";");
			while(rs.next())
			{
				Subvencion subvencion=new Subvencion();
				subvencion.setTitulo((String)rs.getObject("titulo"));
				subvencion.setCategoria((String)rs.getObject("categoria"));
				subvencion.setCondiciones((String)rs.getObject("condiciones"));
				subvencion.setAmbito((String)rs.getObject("ambito"));
				subvencion.setObjeto((String)rs.getObject("objeto"));
				subvencion.setLugar((String)rs.getObject("lugar"));
				subvencion.setId((Integer)rs.getObject("id"));
				busqueda.add(subvencion);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return busqueda;
	}
	
	public static ArrayList<Subvencion> getListaNuevasSubvenciones()
	{
		ArrayList<Subvencion> subvenciones=new ArrayList<Subvencion>();
		
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try
		{
			Connection connection =ds.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM  subvenciones WHERE nueva=true;");
			while(rs.next())
			{
				//(titulo,categoria,condiciones,ambito,objeto,lugar)
				Subvencion subvencion=new Subvencion();
				subvencion.setTitulo((String)rs.getObject("titulo"));
				subvencion.setCategoria((String)rs.getObject("categoria"));
				subvencion.setCondiciones((String)rs.getObject("condiciones"));
				subvencion.setAmbito((String)rs.getObject("ambito"));
				subvencion.setObjeto((String)rs.getObject("objeto"));
				subvencion.setLugar((String)rs.getObject("lugar"));
				subvencion.setId((Integer)rs.getObject("id"));
				subvenciones.add(subvencion);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return subvenciones;
	}
	
	public static boolean envejecerSubvenciones()
	{
		Connection connection =null;
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUser(login);
		ds.setPassword("si3");
		ds.setServerName(servidor);
		ds.setPort(3306);
		ds.setDatabaseName("si3_144");
		try {
			connection =ds.getConnection();
			connection.setAutoCommit(false);
			Statement st1 = connection.createStatement();
			String SQL ="UPDATE subvenciones SET nueva=false WHERE nueva=true";
			st1.executeUpdate(SQL);
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			try { e.printStackTrace(); connection.rollback(); return false;} catch (SQLException e1) {e1.printStackTrace(); return false;}
		}
	}
}


