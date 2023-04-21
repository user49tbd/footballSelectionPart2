package footballApplication.footballApplicationV2.persistence;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footballApplication.footballApplicationV2.model.FinaisMod;
import footballApplication.footballApplicationV2.model.GrpsID;
import footballApplication.footballApplicationV2.model.GruposDadosMod;
import footballApplication.footballApplicationV2.model.GruposMod;
import footballApplication.footballApplicationV2.model.PartidaStatusMod;
import footballApplication.footballApplicationV2.model.RodadaMod;
import footballApplication.footballApplicationV2.model.TimesMod;

@Repository
public class DaoTime {
	@Autowired
	GenericDao gdao;
	
	private String msg="";
	
	public List<TimesMod> getTimes() throws SQLException, ClassNotFoundException {
		Connection c = gdao.getC();
		StringBuffer sb1 = new StringBuffer();
		sb1.append("SELECT T.NOMETIME,T.CIDADE,T.ESTADIO,T.MATERIALE ");
		sb1.append("FROM TIMES T ORDER BY T.NOMETIME");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ResultSet rs = ps.executeQuery();
		List<TimesMod> lt = new ArrayList<>();
		while(rs.next()) {
			TimesMod t = new TimesMod();
			t.setNomeTime(rs.getString("NOMETIME"));
			t.setCidade(rs.getString("CIDADE"));
			t.setEstadio(rs.getString("ESTADIO"));
			t.setMaterial(rs.getString("MATERIALE"));
			lt.add(t);
		}
		return lt;
	}
	
	public List<GruposMod> getGrupos(String grup) throws SQLException, ClassNotFoundException {
		Connection c = gdao.getC();
		StringBuffer sb1 = new StringBuffer();
		sb1.append("SELECT T.NOMETIME,G.GRP FROM GRUPO G INNER JOIN TIMES T ");
		sb1.append("ON T.CODIGOTIME = G.TIMECOD WHERE G.GRP LIKE ? ");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setString(1, grup);
		ResultSet rs = ps.executeQuery();
		List<GruposMod> lt = new ArrayList<GruposMod>();
		while(rs.next()) {
			GruposMod g = new GruposMod();
			g.setNomeTime(rs.getString("NOMETIME"));
			g.setGrupo(grup);
			lt.add(g);
		}
		return lt;
	}
	public List<RodadaMod> getRodada(LocalDate ld) throws SQLException, ClassNotFoundException{
		Connection c = gdao.getC();
		setMsg("");
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT T1.NOMETIME AS TIME_A,J.GOLSTIMEA,T2.NOMETIME AS TIME_B, ");
		sb.append("J.GOLSTIMEB  FROM JOGOS J INNER JOIN TIMES T1 ON ");
		sb.append("J.CODIGOTIMEA = T1.CODIGOTIME INNER JOIN TIMES T2 ");
		sb.append("ON T2.CODIGOTIME = J.CODIGOTIMEB ");
		sb.append("WHERE CONVERT(VARCHAR(12),J.DATA,31) = ? ");
		
		PreparedStatement ps = c.prepareStatement(sb.toString());
		ps.setDate(1, Date.valueOf(ld));
		//System.out.println(Date.valueOf(ld));
		List<RodadaMod> lc = new ArrayList<RodadaMod>();
		
		ResultSet rs = ps.executeQuery();
		//System.out.println("ok execker");
		while(rs.next()) {
			RodadaMod rdm = new RodadaMod();
			rdm.setTimeNomeA(rs.getString("TIME_A"));
			rdm.setTimeNomeB(rs.getString("TIME_B"));
			rdm.setGolsA(rs.getInt("GOLSTIMEA"));
			rdm.setGolsB(rs.getInt("GOLSTIMEB"));
			rdm.setData(ld);
			lc.add(rdm);
			//System.out.println(rdm);
		}
		
		if(lc.isEmpty() == true) {
			setMsg("Nao ha jogos na data especificada");
		}
		c.close();
		return lc;
	}
	public void RodadasGen() throws SQLException, ClassNotFoundException {
		Connection c = gdao.getC();
		String sql ="{CALL INITIAL}";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		cs.close();
	}
	public List<FinaisMod> getFinais() throws ClassNotFoundException, SQLException{
		Connection c = gdao.getC();
		String sql = "SELECT NTIMEA,NTIMEB FROM F_FINAL_PROJ ()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<FinaisMod> lt = new ArrayList<>();
		while(rs.next()) {
			FinaisMod fm = new FinaisMod();
			fm.setTimeA(rs.getString("NTIMEA"));
			fm.setTimeB(rs.getString("NTIMEB"));
			lt.add(fm);
		}
		c.close();
		return lt;
	}
	public List<GruposDadosMod> getGrupoDadosMod(String opt) throws ClassNotFoundException, SQLException{
		Connection c = gdao.getC();
		String sql = "SELECT * FROM F_GRUPOS_DADOS_STATUS (?) T\r\n"
				+ "ORDER BY T.PONTOS DESC,T.VITORIAS DESC, T.GOLS_MARCADOS DESC, T.SALDO_GOLS DESC";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,opt);
		ResultSet rs = ps.executeQuery();
		List<GruposDadosMod> lt = new ArrayList<>();
		while(rs.next()) {
			GruposDadosMod gdm = new GruposDadosMod();
			gdm.setNomeTime(rs.getString("NOME_TIME"));
			gdm.setDerrotas(rs.getInt("DERROTAS"));
			gdm.setEmpates(rs.getInt("EMPATES"));
			gdm.setGolsMarcados(rs.getInt("GOLS_MARCADOS"));
			gdm.setGolsSofridos(rs.getInt("GOLS_SOFRIDOS"));
			gdm.setGrp(rs.getString("GRP"));
			gdm.setNumJogosDisputados(rs.getInt("NUM_JOGOS_DISPUTADOS"));
			gdm.setOtime(rs.getInt("OTIME"));
			gdm.setPontos(rs.getInt("PONTOS"));
			gdm.setSaldoGols(rs.getInt("SALDO_GOLS"));
			gdm.setTimeStatus(rs.getString("TIMESTATUS"));
			gdm.setVitorias(rs.getInt("VITORIAS"));
			lt.add(gdm);
		}
		c.close();
		return lt;
	}
	public List<GrpsID> getGrps() throws ClassNotFoundException, SQLException{
		Connection c = gdao.getC();
		String sql = "SELECT * FROM GRUPOSNOME";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<GrpsID> lt = new ArrayList<>();
		while(rs.next()) {
			GrpsID grp = new GrpsID();
			grp.setGrp(rs.getString("NOME"));
			grp.setId(rs.getInt("ID"));
			lt.add(grp);
		}
		c.close();
		return lt;
	}
	public List<String> getTimesNome() throws ClassNotFoundException, SQLException{
		Connection c = gdao.getC();
		String sql="SELECT T.NOMETIME FROM TIMES T";
		List<String> ls = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ls.add(rs.getString("NOMETIME"));
		}
		c.close();
		return ls;
	}
	public PartidaStatusMod getPartidaStatus(String time,LocalDate data) throws ClassNotFoundException, SQLException {
		Connection c = gdao.getC();
		String sql="CALL P_PARTIDA ?,?";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, time);
		cs.setDate(2, Date.valueOf(data));
		cs.execute();
		cs.close();
		sql = "SELECT TID1,T1NOME,T1GOLS,TID2,T2NOME,T2GOLS FROM PTSTATUS";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		PartidaStatusMod psm = new PartidaStatusMod();
		if(rs.next()){
			psm.setT1grp(rs.getString("TID1"));
			psm.setT1nome(rs.getString("T1NOME"));
			psm.setT1gols(rs.getInt("T1GOLS"));
			psm.setT2grp(rs.getString("TID2"));
			psm.setT2nome(rs.getString("T2NOME"));
			psm.setT2gols(rs.getInt("T2GOLS"));
		}
		sql = "DELETE PTSTATUS";
		ps = c.prepareStatement(sql);
		ps.execute();
		c.close();
		return psm;
	}
	public void updPartida(PartidaStatusMod psm,LocalDate data) throws ClassNotFoundException, SQLException {
		Connection c = gdao.getC();
		//--EXEC P_UPDJOGOS(@GOLSA INT, @GOLSB INT,@NOMETA VARCHAR(50),@NOMETB VARCHAR(50),@DATA DATE)
		String sql="CALL P_UPDJOGOS(?,?,?,?,?)";
		CallableStatement cs = c.prepareCall(sql);
		if(psm.getT1grp().equalsIgnoreCase("A")) {
			System.out.println("Time1 = A - "+psm.getT1grp());
			cs.setInt(1, psm.getT1gols());
			cs.setInt(2, psm.getT2gols());
			cs.setString(3, psm.getT1nome());
			cs.setString(4, psm.getT2nome());
		}
		else {
			System.out.println("Time1 = B - "+psm.getT1grp());
			cs.setInt(1, psm.getT2gols());
			cs.setInt(2, psm.getT1gols());
			cs.setString(3, psm.getT2nome());
			cs.setString(4, psm.getT1nome());
		}
		cs.setDate(5, Date.valueOf(data));
		cs.execute();
		c.close();
		}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
