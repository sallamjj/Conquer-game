package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.Stable;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class First implements ActionListener {
	Game game;
	JTextField playername;
	JRadioButton RB1, RB2, RB3;
	JButton SG, c, r, s, map, market, farm, archeryrange, barracks, stable, endturn, upgrademarket, upgradefarm,
			upgradestable, upgradebarracks, upgradearcheryrange,viewarmycr,viewarmycs,viewarmycc,bcc,bcr,bcs,bbes,bmar,bidl;
	JLabel LB1, LB2, p, t, g, f, pv, tv, gv, fv, Ls, La, Lb, Lm, Lf, su, sa, su2, cl, worldmap, lcairo, choose1,
			choose2, soldier1, soldier2, ll, lll, llll, cong, titlefc, titlefr, titlefs;
	JButton marketphoto, farmphoto, stablephoto, barracksphoto, archeryrangephoto, recruitarcher, recruitinfantry,
			recruitcavalry, backtocity;
	JButton viewarmy, viewcity, archer, unitindex, inarmy, reunit, attackc, attackr, attacks, autoc, autor, autos,
			seigec, seiger, seiges, targetc, targetr, targets, FORphoto, FOCphoto, FOSphoto, backmenuc, backmenur,
			backmenus;
	JButton buttondefr, buttondefs, buttonattr, buttonatts, startbattler, startbattles, attackercr, attackercs,
			backtocityr, backtocitys, autofc, autofr, autofs, attackfc, attackfr, attackfs,showw;
	JFrame F1, F2, FC, F4, F5, F6, FA, FB, FBR, FBS, FT, FR, FAR, FS, FAS, FTR, FTS, FFC, FFR, FFS, FOC, FOR, FOS,FBES,FMAR,FIDL,FCC,FCR,FCS;
	JPanel panel, img, panell;
	int citychecker;
	boolean f1, f2,flagoo1,flagoo2,flagoo3,flagg;
	ImageIcon image;
	JComboBox<String> Armies;
	Unit att, def;
	String type1, type2;
	int archerX, infantryX, cavalryX, archerY, infantryY, cavalryY, unitcounter,xa,xi,xc,ya,yi,yc;
	String[] units, unitss, armies, attacku, defendu, armiesa;
	JComboBox<JButton> cityUnitss, cityUnits, coarmies, attackuc, defenduc, coarmiesa;
	JButton sarmy, attackerc, buttonatt, buttondef, startbattle, mbutton;
	boolean checkc, checkr, checks, fc, fr, fs;
	JButton viewarmyr, viewarmys, viewcityr, viewcitys, marketr, markets, marketphotor, marketphotos, upgrademarketr,
			upgrademarkets, farmr, farms, farmphotor, farmphotos, upgradefarmr, upgradefarms, barracksr, barrackss;
	JButton recruitinfantryr, recruitinfantrys, barracksphotor, barracksphotos, upgradebarracksr, upgradebarrackss,
			archeryranger, archeryranges, recruitarcherr, recruitarchers, archeryrangephotor, archeryrangephotos;
	JButton upgradearcheryranger, upgradearcheryranges, stabler, stables, recruitcavalryr, recruitcavalrys,
			stablephotor, stablephotos, upgradestabler, upgradestables, endturnr, endturns, mapr, maps;
	JLabel Lsr, Lss, Lar, Las, Lbr, Lbs, Lmr, Lms, Lfr, Lfs, soldier1r, soldier1s, soldier2r, soldier2s, choose1r,
			choose1s, choose2r, choose2s, congr, congs, useigec, useiger, useiges, llle, lllle, urarmy, urarmyr,
			urarmys, hisarmy, hisarmyr, hisarmys;
	JScrollPane scroll;

	public First() {
		flagoo1=false;
		flagoo2=false;
		flagoo3=false;
		checkc = false;
		checks = false;
		checkr = false;


//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		lll = new JLabel("Unit is dead");

		llll = new JLabel("Chosse another one");

		llle = new JLabel("Unit is dead");

		lllle = new JLabel("Chosse another one");

		mbutton = new JButton("");

		F1 = new JFrame();
		playername = new JTextField();
		playername.setBounds(600, 150, 300, 50);
		F1.getContentPane().add(playername);
		playername.setBorder(BorderFactory.createLineBorder(Color.black));

		RB1 = new JRadioButton("Cairo");
		RB1.setBounds(500, 350, 200, 50);
		F1.getContentPane().add(RB1);
		RB1.setFont(RB1.getFont().deriveFont(Font.BOLD, 14f));
		RB1.setForeground(Color.RED);

		RB2 = new JRadioButton("Rome");
		RB2.setBounds(750, 350, 200, 50);
		F1.getContentPane().add(RB2);
		RB2.setFont(RB2.getFont().deriveFont(Font.BOLD, 14f));
		RB2.setForeground(Color.RED);

		RB3 = new JRadioButton("Sparta");
		RB3.setBounds(1000, 350, 200, 50);
		F1.getContentPane().add(RB3);
		RB3.setFont(RB3.getFont().deriveFont(Font.BOLD, 14f));
		RB3.setForeground(Color.RED);

		citychecker = 0;

		ButtonGroup RB123 = new ButtonGroup();
		RB123.add(RB1);
		RB123.add(RB2);
		RB123.add(RB3);

		SG = new JButton("Start Game");
		SG.setBounds(600, 500, 300, 100);
		SG.addActionListener(this);

		F1.getContentPane().add(SG);
		SG.setBorder(BorderFactory.createLineBorder(Color.black));
		SG.setBackground(Color.WHITE);

		LB1 = new JLabel("Name of Player :");
		LB1.setBounds(400, 150, 200, 50);
		F1.getContentPane().add(LB1);
		LB1.setFont(LB1.getFont().deriveFont(Font.BOLD + Font.ITALIC, 15f));

		LB2 = new JLabel("Select a City :");
		LB2.setBounds(400, 250, 200, 50);
		F1.getContentPane().add(LB2);
		LB2.setFont(LB2.getFont().deriveFont(Font.BOLD + Font.ITALIC, 15f));

		F1.getContentPane().setLayout(null);
		F1.setTitle("GAME");
		F1.setSize(1500, 750);
		F1.setVisible(true);
		F1.setResizable(false);

		F2 = new JFrame();
		F2.setSize(1500, 750);
		F2.getContentPane().setLayout(null);
		F2.setVisible(false);
		F2.setResizable(false);

		FT = new JFrame();
		FT.setSize(1500, 750);
		FT.getContentPane().setLayout(null);
		FT.setVisible(false);
		FT.setResizable(false);

		FTR = new JFrame();
		FTR.setSize(1500, 750);
		FTR.getContentPane().setLayout(null);
		FTR.setVisible(false);
		FTR.setResizable(false);

		FTS = new JFrame();
		FTS.setSize(1500, 750);
		FTS.getContentPane().setLayout(null);
		FTS.setVisible(false);
		FTS.setResizable(false);

		backtocity = new JButton("Back To World Map");
		backtocity.setBounds(500, 250, 500, 200);
		backtocity.addActionListener(this);
		FT.add(backtocity);

		backtocityr = new JButton("Back To World Map");
		backtocityr.setBounds(500, 250, 500, 200);
		backtocityr.addActionListener(this);
		FTR.add(backtocityr);

		backtocitys = new JButton("Back To World Map");
		backtocitys.setBounds(500, 250, 500, 200);
		backtocitys.addActionListener(this);
		FTS.add(backtocitys);

		cong = new JLabel("Congratulations!!! You Won The Battle");
		cong.setBounds(650, 200, 500, 50);
		FT.add(cong);

		congr = new JLabel("Congratulations!!! You Won The Battle");
		congr.setBounds(650, 200, 500, 50);
		FTR.add(congr);

		congs = new JLabel("Congratulations!!! You Won The Battle");
		congs.setBounds(650, 200, 500, 50);
		FTS.add(congs);

		FA = new JFrame();
		FA.setSize(1500, 810);
		FA.getContentPane().setLayout(null);
		FA.setVisible(false);
		FA.setResizable(false);

		c = new JButton("Cairo");
		c.setBounds(250, 50, 200, 100);
		c.addActionListener(this);
		F2.add(c);

		useigec = new JLabel();
		useigec.setBounds(318, 150, 400, 40);
		F2.add(useigec);
		useigec.setVisible(false);

		FFC = new JFrame();
		FFC.setSize(1500, 750);
		FFC.getContentPane().setLayout(null);
		FFC.setVisible(false);
		FFC.setResizable(false);

		FFR = new JFrame();
		FFR.setSize(1500, 750);
		FFR.getContentPane().setLayout(null);
		FFR.setVisible(false);
		FFR.setResizable(false);

		FOC = new JFrame();
		FOC.setSize(1500, 750);
		FOC.getContentPane().setLayout(null);
		FOC.setVisible(false);
		FOC.setResizable(false);

		FOR = new JFrame();
		FOR.setSize(1500, 750);
		FOR.getContentPane().setLayout(null);
		FOR.setVisible(false);
		FOR.setResizable(false);

		FOS = new JFrame();
		FOS.setSize(1500, 750);
		FOS.getContentPane().setLayout(null);
		FOS.setVisible(false);
		FOS.setResizable(false);

		FOCphoto = new JButton();
		FOCphoto.setBounds(0, 0, 1500, 620);
		FOCphoto.setIcon(new ImageIcon(this.getClass().getResource("/gameover.png").getFile()));
		FOC.add(FOCphoto);

		backmenuc = new JButton("Return To Start Menu");
		backmenuc.addActionListener(this);
		backmenuc.setBounds(0, 620, 1500, 100);
		FOC.add(backmenuc);

		FORphoto = new JButton();
		FORphoto.setBounds(0, 0, 1500, 620);
		FORphoto.setIcon(new ImageIcon(this.getClass().getResource("/gameover.png").getFile()));
		FOR.add(FORphoto);

		backmenur = new JButton("Return To Start Menu");
		backmenur.addActionListener(this);
		backmenur.setBounds(0, 620, 1500, 100);
		FOR.add(backmenur);

		FOSphoto = new JButton();
		FOSphoto.setBounds(0, 0, 1500, 620);
		FOSphoto.setIcon(new ImageIcon(this.getClass().getResource("/gameover.png").getFile()));
		FOS.add(FOSphoto);

		backmenus = new JButton("Return To Start Menu");
		backmenus.addActionListener(this);
		backmenus.setBounds(0, 620, 1500, 100);
		FOS.add(backmenus);

		FFS = new JFrame();
		FFS.setSize(1500, 750);
		FFS.getContentPane().setLayout(null);
		FFS.setVisible(false);
		FFS.setResizable(false);

		attackc = new JButton("Attack");
		attackc.setBounds(450, 50, 150, 25);
		attackc.addActionListener(this);
		F2.add(attackc);

		autoc = new JButton("Auto Resolve");
		autoc.setBounds(450, 75, 150, 25);
		autoc.addActionListener(this);
		F2.add(autoc);

		autofc = new JButton("Auto Resolve");
		autofc.setBounds(750, 275, 250, 200);
		autofc.addActionListener(this);
		FFC.add(autofc);

		autofr = new JButton("Auto Resolve");
		autofr.setBounds(750, 275, 250, 200);
		autofr.addActionListener(this);
		FFR.add(autofr);

		autofs = new JButton("Auto Resolve");
		autofs.setBounds(750, 275, 250, 200);
		autofs.addActionListener(this);
		FFS.add(autofs);

		attackfc = new JButton("Attack");
		attackfc.setBounds(500, 275, 250, 200);
		attackfc.addActionListener(this);
		FFC.add(attackfc);

		attackfr = new JButton("Attack");
		attackfr.setBounds(500, 275, 250, 200);
		attackfr.addActionListener(this);
		FFR.add(attackfr);

		attackfs = new JButton("Attack");
		attackfs.setBounds(500, 275, 250, 200);
		attackfs.addActionListener(this);
		FFS.add(attackfs);

		titlefc = new JLabel(" Cairo reached maximum TurnsUnderSeige   U must Attack or AutoResolve");
		titlefc.setBounds(530, 225, 500, 50);
		FFC.add(titlefc);

		titlefr = new JLabel(" Rome reached maximum TurnsUnderSeige   U must Attack or AutoResolve");
		titlefr.setBounds(530, 225, 500, 50);
		FFR.add(titlefr);

		titlefs = new JLabel("Sparta reached maximum TurnsUnderSeige   U must Attack or AutoResolve");
		titlefs.setBounds(530, 225, 500, 50);
		FFS.add(titlefs);

		targetc = new JButton("Target");
		targetc.setBounds(450, 100, 150, 25);
		targetc.addActionListener(this);
		F2.add(targetc);

		autos = new JButton("Auto Resolve");
		autos.setBounds(1250, 75, 150, 25);
		autos.addActionListener(this);
		F2.add(autos);

		targets = new JButton("Target");
		targets.setBounds(1250, 100, 150, 25);
		targets.addActionListener(this);
		F2.add(targets);

		seiges = new JButton("Lay Seige");
		seiges.setBounds(1250, 125, 150, 25);
		seiges.addActionListener(this);
		F2.add(seiges);

		autor = new JButton("Auto Resolve");
		autor.setBounds(850, 75, 150, 25);
		autor.addActionListener(this);
		F2.add(autor);

		seigec = new JButton("Lay Seige");
		seigec.setBounds(450, 125, 150, 25);
		seigec.addActionListener(this);
		F2.add(seigec);

		targetr = new JButton("Target");
		targetr.setBounds(850, 100, 150, 25);
		targetr.addActionListener(this);
		F2.add(targetr);

		seiger = new JButton("Lay Seige");
		seiger.setBounds(850, 125, 150, 25);
		seiger.addActionListener(this);
		F2.add(seiger);

		lcairo = new JLabel();

		attackr = new JButton("Attack");
		attackr.setBounds(850, 50, 150, 25);
		attackr.addActionListener(this);
		F2.add(attackr);

		attacks = new JButton("Attack");
		attacks.setBounds(1250, 50, 150, 25);
		attacks.addActionListener(this);
		F2.add(attacks);

		r = new JButton("Rome");
		r.setBounds(650, 50, 200, 100);
		r.addActionListener(this);
		F2.add(r);

		useiger = new JLabel();
		useiger.setBounds(718, 150, 400, 40);
		F2.add(useiger);
		useiger.setVisible(false);

		s = new JButton("Sparta");
		s.setBounds(1050, 50, 200, 100);
		s.addActionListener(this);
		F2.add(s);

		useiges = new JLabel();
		useiges.setBounds(1118, 150, 400, 40);
		F2.add(useiges);
		useiges.setVisible(false);

		// worldmap=new JLabel();
		// worldmap.setBounds(0,0,1500,750);
		// worldmap.setIcon(new
		// ImageIcon(this.getClass().getResource("/worldmap.png").getFile()));
		// F2.add(worldmap);

		p = new JLabel("Player's name:");
		p.setBounds(50, 500, 200, 50);

		t = new JLabel("Turn Count:");
		t.setBounds(50, 550, 200, 50);
		F2.add(t);

		g = new JLabel("Gold:");
		g.setBounds(50, 600, 200, 50);
		F2.add(g);

		f = new JLabel("Food:");
		f.setBounds(50, 650, 200, 50);
		F2.add(f);

		/*
		
		 * ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\farm.png"));
		 * panel.add(L); FC.setLocationRelativeTo(null); FC.pack(); FC.setVisible(true);
		 */

		units = new String[200];
		cityUnits = new JComboBox(units);
		cityUnits.setBounds(110, 250, 400, 40);
		F2.add(cityUnits);

		inarmy = new JButton("Initiate Army");
		inarmy.setBounds(10, 200, 500, 40);
		inarmy.addActionListener(this);
		F2.add(inarmy);

		sarmy = new JButton("Prepare Army");
		sarmy.setBounds(350, 350, 500, 50);
		sarmy.addActionListener(this);
		F2.add(sarmy);

		armiesa = new String[200];
		coarmiesa = new JComboBox(armiesa);
		coarmiesa.setBounds(350, 400, 500, 50);
		F2.add(coarmiesa);

		su = new JLabel("Select a unit");
		su.setBounds(10, 250, 200, 40);
		F2.add(su);

		armies = new String[200];
		coarmies = new JComboBox(armies);
		coarmies.setBounds(650, 300, 400, 40);
		F2.add(coarmies);

		FB = new JFrame();
		FB.setSize(1500, 750);
		FB.getContentPane().setLayout(null);
		FB.setVisible(false);
		FB.setResizable(false);

		FBR = new JFrame();
		FBR.setSize(1500, 750);
		FBR.getContentPane().setLayout(null);
		FBR.setVisible(false);
		FBR.setResizable(false);

		FBS = new JFrame();
		FBS.setSize(1500, 750);
		FBS.getContentPane().setLayout(null);
		FBS.setVisible(false);
		FBS.setResizable(false);

		ll = new JLabel();
		ll.setBounds(0, 0, 5, 5);
		FB.add(ll);

		buttondefs = new JButton();
		buttondefs.setBounds(1000, 400, 300, 350);
		// buttondef.setIcon(new
		// ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
		buttondefs.setVisible(true);
		FBS.add(buttondefs);

		buttonatts = new JButton();
		buttonatts.setBounds(200, 400, 300, 350);
		// buttonatt.setIcon(new
		// ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
		buttonatts.setVisible(true);
		FBS.add(buttonatts);

		fc = false;
		fr = false;
		fs = false;

		soldier1s = new JLabel();
		soldier1s.setBounds(225, 350, 300, 50);
		FBS.add(soldier1s);

		soldier2s = new JLabel();
		soldier2s.setBounds(1025, 350, 300, 50);
		FBS.add(soldier2s);

		startbattles = new JButton("Start");
		startbattles.setBounds(700, 150, 100, 70);
		startbattles.addActionListener(this);
		FBS.add(startbattles);

		buttondefr = new JButton();
		buttondefr.setBounds(1000, 400, 300, 350);
		// buttondef.setIcon(new
		// ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
		buttondefr.setVisible(true);
		FBR.add(buttondefr);

		buttonattr = new JButton();
		buttonattr.setBounds(200, 400, 300, 350);
		// buttonatt.setIcon(new
		// ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
		buttonattr.setVisible(true);
		FBR.add(buttonattr);

		soldier1r = new JLabel();
		soldier1r.setBounds(225, 350, 300, 50);
		FBR.add(soldier1r);

		soldier2r = new JLabel();
		soldier2r.setBounds(1025, 350, 300, 50);
		FBR.add(soldier2r);

		startbattler = new JButton("Start");
		startbattler.setBounds(700, 150, 100, 70);
		startbattler.addActionListener(this);
		FBR.add(startbattler);

		buttondef = new JButton();
		buttondef.setBounds(1000, 400, 300, 350);
		// buttondef.setIcon(new
		// ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
		buttondef.setVisible(true);
		FB.add(buttondef);

		buttonatt = new JButton();
		buttonatt.setBounds(200, 400, 300, 350);
		// buttonatt.setIcon(new
		// ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
		buttonatt.setVisible(true);
		FB.add(buttonatt);

		soldier1 = new JLabel();
		soldier1.setBounds(225, 350, 300, 50);
		FB.add(soldier1);

		soldier2 = new JLabel();
		soldier2.setBounds(1025, 350, 300, 50);
		FB.add(soldier2);

		startbattle = new JButton("Start");
		startbattle.setBounds(700, 150, 100, 70);
		startbattle.addActionListener(this);
		FB.add(startbattle);

		attacku = new String[100];
		attackuc = new JComboBox(attacku);
		attackuc.setBounds(100, 100, 400, 50);
		FB.add(attackuc);

		choose1 = new JLabel("Select a unit");
		choose1.setBounds(270, 50, 200, 50);
		FB.add(choose1);

		choose2 = new JLabel("Select a unit");
		choose2.setBounds(1170, 50, 200, 50);
		FB.add(choose2);

		choose1r = new JLabel("Select a unit");
		choose1r.setBounds(270, 50, 200, 50);
		FBR.add(choose1r);

		choose2r = new JLabel("Select a unit");
		choose2r.setBounds(1170, 50, 200, 50);
		FBR.add(choose2r);

		choose1s = new JLabel("Select a unit");
		choose1s.setBounds(270, 50, 200, 50);
		FBS.add(choose1s);

		choose2s = new JLabel("Select a unit");
		choose2s.setBounds(1170, 50, 200, 50);
		FBS.add(choose2s);

		urarmy = new JLabel("Your Army");
		urarmy.setBounds(275, 0, 200, 50);
		FB.add(urarmy);

		hisarmy = new JLabel("Enemy Army");
		hisarmy.setBounds(1175, 0, 200, 50);
		FB.add(hisarmy);

		urarmyr = new JLabel("Your Army");
		urarmyr.setBounds(275, 0, 200, 50);
		FBR.add(urarmyr);

		hisarmyr = new JLabel("Enemy Army");
		hisarmyr.setBounds(1175, 0, 200, 50);
		FBR.add(hisarmyr);

		urarmys = new JLabel("Your Army");
		urarmys.setBounds(275, 0, 200, 50);
		FBS.add(urarmys);

		hisarmys = new JLabel("Enemy Army");
		hisarmys.setBounds(1175, 0, 200, 50);
		FBS.add(hisarmys);

		defendu = new String[100];
		defenduc = new JComboBox(defendu);
		defenduc.setBounds(1000, 100, 400, 50);
		FB.add(defenduc);

		attackerc = new JButton();
		attackerc.setBounds(700, 450, 100, 70);
		attackerc.setIcon(new ImageIcon(this.getClass().getResource("/attack.png").getFile()));
		attackerc.addActionListener(this);
		attackerc.setVisible(false);
		FB.add(attackerc);

		attackercr = new JButton();
		attackercr.setBounds(700, 450, 100, 70);
		attackercr.setIcon(new ImageIcon(this.getClass().getResource("/attack.png").getFile()));
		attackercr.addActionListener(this);
		attackercr.setVisible(false);
		FBR.add(attackercr);

		attackercs = new JButton();
		attackercs.setBounds(700, 450, 100, 70);
		attackercs.setIcon(new ImageIcon(this.getClass().getResource("/attack.png").getFile()));
		attackercs.addActionListener(this);
		attackercs.setVisible(false);
		FBS.add(attackercs);

		reunit = new JButton("Relocate Unit");
		reunit.setBounds(550, 200, 500, 40);
		reunit.addActionListener(this);
		F2.add(reunit);

		su2 = new JLabel("Select a unit");
		su2.setBounds(550, 250, 200, 40);
		F2.add(su2);

		unitss = new String[200];
		cityUnitss = new JComboBox(unitss);
		cityUnitss.setBounds(650, 250, 400, 40);
		F2.add(cityUnitss);

		sa = new JLabel("Select an army");
		sa.setBounds(550, 300, 200, 40);
		F2.add(sa);

		String[] geysh = { "Beseiging Armies", "Marching Armies", "Idle Armies" };
		Armies = new JComboBox(geysh);
		Armies.setBounds(1000, 400, 200, 50);
		F2.getContentPane().add(Armies);
		
		FBES = new JFrame();
		FBES.setSize(1500, 750);
		FBES.getContentPane().setLayout(null);
		FBES.setVisible(false);
		FBES.setResizable(false);
		
		FMAR = new JFrame();
		FMAR.setSize(1500, 750);
		FMAR.getContentPane().setLayout(null);
		FMAR.setVisible(false);
		FMAR.setResizable(false);
		
		FIDL = new JFrame();
		FIDL.setSize(1500, 750);
		FIDL.getContentPane().setLayout(null);
		FIDL.setVisible(false);
		FIDL.setResizable(false);
		
		showw =new JButton("SHOW");
		showw.setBounds(1200, 400, 100, 50);
		showw.addActionListener(this);
		F2.add(showw);

		FC = new JFrame();
		FC.setSize(1500, 750);
		FC.getContentPane().setLayout(null);
		FC.setVisible(false);
		FC.setResizable(false);

		FR = new JFrame();
		FR.setSize(1500, 750);
		FR.getContentPane().setLayout(null);
		FR.setVisible(false);
		FR.setResizable(false);

		FAR = new JFrame();
		FAR.setSize(1500, 810);
		FAR.getContentPane().setLayout(null);
		FAR.setVisible(false);
		FAR.setResizable(false);

		FAS = new JFrame();
		FAS.setSize(1500, 810);
		FAS.getContentPane().setLayout(null);
		FAS.setVisible(false);
		FAS.setResizable(false);
		
		FCC = new JFrame();
		FCC.setSize(1500, 750);
		FCC.getContentPane().setLayout(null);
		FCC.setVisible(false);
		FCC.setResizable(false);
		
		FCR = new JFrame();
		FCR.setSize(1500, 750);
		FCR.getContentPane().setLayout(null);
		FCR.setVisible(false);
		FCR.setResizable(false);
		
		FCS = new JFrame();
		FCS.setSize(1500, 750);
		FCS.getContentPane().setLayout(null);
		FCS.setVisible(false);
		FCS.setResizable(false);

		viewarmyr = new JButton("View Defending Army");
		viewarmyr.setBounds(950, 600, 300, 100);
		viewarmyr.addActionListener(this);
		FR.add(viewarmyr);
		
		bcc = new JButton("Back To City");
		bcc.setBounds(1200, 600, 280, 100);
		bcc.addActionListener(this);
		FCC.add(bcc);
		
		bbes = new JButton("Back To World Map");
		bbes.setBounds(1200, 600, 280, 100);
		bbes.addActionListener(this);
		FBES.add(bbes);
		
		bmar = new JButton("Back To World Map");
		bmar.setBounds(1200, 600, 280, 100);
		bmar.addActionListener(this);
		FMAR.add(bmar);
		
		bidl = new JButton("Back To World Map");
		bidl.setBounds(1200, 600, 280, 100);
		bidl.addActionListener(this);
		FIDL.add(bidl);
		
		bcr = new JButton("Back To City");
		bcr.setBounds(1200, 600, 280, 100);
		bcr.addActionListener(this);
		FCR.add(bcr);
		
		bcs = new JButton("Back To City");
		bcs.setBounds(1200, 600, 280, 100);
		bcs.addActionListener(this);
		FCS.add(bcs);

		viewcityr = new JButton("Back To City");
		viewcityr.setBounds(1180, 730, 300, 40);
		viewcityr.addActionListener(this);
		FAR.add(viewcityr);

		marketr = new JButton("Construct Market" + "  cost 1500");
		marketr.setBounds(250, 250, 500, 200);
		marketr.addActionListener(this);
		FR.add(marketr);

		marketphotor = new JButton();
		marketphotor.setBounds(250, 250, 500, 100);
		marketphotor.setIcon(new ImageIcon(this.getClass().getResource("/market.png").getFile()));
		marketphotor.setVisible(false);
		FR.add(marketphotor);

		upgrademarketr = new JButton("Upgrade Market");
		upgrademarketr.setBounds(250, 380, 500, 70);
		upgrademarketr.setVisible(false);
		upgrademarketr.addActionListener(this);
		FR.add(upgrademarketr);

		farmr = new JButton("Construct Farm" + "  cost 1000");
		farmr.setBounds(750, 250, 500, 200);
		farmr.addActionListener(this);
		FR.add(farmr);
		// FR.add(new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\farm.png")));

		farmphotor = new JButton();
		farmphotor.setBounds(750, 250, 500, 100);
		farmphotor.setIcon(new ImageIcon(this.getClass().getResource("/farm.png").getFile()));
		farmphotor.setVisible(false);
		FR.add(farmphotor);

		upgradefarmr = new JButton("Upgrade Farm ");
		upgradefarmr.setBounds(750, 380, 500, 70);
		upgradefarmr.setVisible(false);
		upgradefarmr.addActionListener(this);
		FR.add(upgradefarmr);

		barracksr = new JButton("Construct Barracks" + "  cost 2000");
		barracksr.setBounds(500, 0, 500, 230);
		barracksr.addActionListener(this);
		FR.add(barracksr);

		recruitinfantryr = new JButton("Recruit Infantry " + "cost 500");
		recruitinfantryr.setBounds(500, 180, 500, 50);
		recruitinfantryr.addActionListener(this);
		FR.add(recruitinfantryr);

		barracksphotor = new JButton();
		barracksphotor.setBounds(500, 0, 500, 100);
		barracksphotor.setIcon(new ImageIcon(this.getClass().getResource("/barracks.png").getFile()));
		barracksphotor.setVisible(false);
		FR.add(barracksphotor);

		upgradebarracksr = new JButton("Upgrade Barracks ");
		upgradebarracksr.setBounds(500, 130, 500, 50);
		upgradebarracksr.setVisible(false);
		upgradebarracksr.addActionListener(this);
		FR.add(upgradebarracksr);

		archeryranger = new JButton("Construct Archery Range" + "  cost 1500");
		archeryranger.setBounds(0, 0, 500, 230);
		archeryranger.addActionListener(this);
		FR.add(archeryranger);

		recruitarcherr = new JButton("Recruit Archer " + "cost 400");
		recruitarcherr.setBounds(0, 180, 500, 50);
		recruitarcherr.addActionListener(this);
		FR.add(recruitarcherr);

		archeryrangephotor = new JButton();
		archeryrangephotor.setBounds(0, 0, 500, 100);
		archeryrangephotor.setIcon(new ImageIcon(this.getClass().getResource("/archeryrange.png").getFile()));
		archeryrangephotor.setVisible(false);
		FR.add(archeryrangephotor);

		upgradearcheryranger = new JButton("Upgrade Archery Range ");
		upgradearcheryranger.setBounds(0, 130, 500, 50);
		upgradearcheryranger.setVisible(false);
		upgradearcheryranger.addActionListener(this);
		FR.add(upgradearcheryranger);

		stabler = new JButton("Construct Stable" + "  cost 2500");
		stabler.setBounds(1000, 0, 500, 230);
		stabler.addActionListener(this);
		FR.add(stabler);

		recruitcavalryr = new JButton("Recruit Cavalry " + "cost 600");
		recruitcavalryr.setBounds(1000, 180, 500, 50);
		recruitcavalryr.addActionListener(this);
		FR.add(recruitcavalryr);

		stablephotor = new JButton();
		stablephotor.setBounds(1000, 0, 500, 100);
		stablephotor.setIcon(new ImageIcon(this.getClass().getResource("/stable.png").getFile()));
		stablephotor.setVisible(false);
		FR.add(stablephotor);

		upgradestabler = new JButton("Upgrade Stable ");
		upgradestabler.setBounds(1000, 130, 500, 50);
		upgradestabler.setVisible(false);
		upgradestabler.addActionListener(this);
		FR.add(upgradestabler);

		mapr = new JButton("Display Map");
		mapr.setBounds(1320, 600, 150, 100);
		mapr.addActionListener(this);
		FR.add(mapr);

		Lsr = new JLabel();
		Lsr.setBounds(1210, 100, 500, 30);
		FR.add(Lsr);

		Lar = new JLabel();
		Lar.setBounds(192, 100, 500, 30);
		FR.add(Lar);

		Lbr = new JLabel();
		Lbr.setBounds(702, 100, 500, 30);
		FR.add(Lbr);

		Lmr = new JLabel();
		Lmr.setBounds(464, 350, 500, 30);
		FR.add(Lmr);

		Lfr = new JLabel();
		Lfr.setBounds(964, 350, 500, 30);
		FR.add(Lfr);

		FS = new JFrame();
		FS.setSize(1500, 750);
		FS.getContentPane().setLayout(null);
		FS.setVisible(false);
		FS.setResizable(false);

		viewarmys = new JButton("View Defending Army");
		viewarmys.setBounds(950, 600, 300, 100);
		viewarmys.addActionListener(this);
		FS.add(viewarmys);

		viewcitys = new JButton("Back To City");
		viewcitys.setBounds(1180, 730, 300, 40);
		viewcitys.addActionListener(this);
		FAS.add(viewcitys);

		markets = new JButton("Construct Market" + "  cost 1500");
		markets.setBounds(250, 250, 500, 200);
		markets.addActionListener(this);
		FS.add(markets);

		marketphotos = new JButton();
		marketphotos.setBounds(250, 250, 500, 100);
		marketphotos.setIcon(new ImageIcon(this.getClass().getResource("/market.png").getFile()));
		marketphotos.setVisible(false);
		FS.add(marketphotos);

		upgrademarkets = new JButton("Upgrade Market");
		upgrademarkets.setBounds(250, 380, 500, 70);
		upgrademarkets.setVisible(false);
		upgrademarkets.addActionListener(this);
		FS.add(upgrademarkets);

		farms = new JButton("Construct Farm" + "  cost 1000");
		farms.setBounds(750, 250, 500, 200);
		farms.addActionListener(this);
		FS.add(farms);
		// FR.add(new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\farm.png")));

		farmphotos = new JButton();
		farmphotos.setBounds(750, 250, 500, 100);
		farmphotos.setIcon(new ImageIcon(this.getClass().getResource("/farm.png").getFile()));
		farmphotos.setVisible(false);
		FS.add(farmphotos);

		upgradefarms = new JButton("Upgrade Farm ");
		upgradefarms.setBounds(750, 380, 500, 70);
		upgradefarms.setVisible(false);
		upgradefarms.addActionListener(this);
		FS.add(upgradefarms);

		barrackss = new JButton("Construct Barracks" + "  cost 2000");
		barrackss.setBounds(500, 0, 500, 230);
		barrackss.addActionListener(this);
		FS.add(barrackss);

		recruitinfantrys = new JButton("Recruit Infantry " + "cost 500");
		recruitinfantrys.setBounds(500, 180, 500, 50);
		recruitinfantrys.addActionListener(this);
		FS.add(recruitinfantrys);

		barracksphotos = new JButton();
		barracksphotos.setBounds(500, 0, 500, 100);
		barracksphotos.setIcon(new ImageIcon(this.getClass().getResource("/barracks.png").getFile()));
		barracksphotos.setVisible(false);
		FS.add(barracksphotos);

		upgradebarrackss = new JButton("Upgrade Barracks ");
		upgradebarrackss.setBounds(500, 130, 500, 50);
		upgradebarrackss.setVisible(false);
		upgradebarrackss.addActionListener(this);
		FS.add(upgradebarrackss);

		archeryranges = new JButton("Construct Archery Range" + "  cost 1500");
		archeryranges.setBounds(0, 0, 500, 230);
		archeryranges.addActionListener(this);
		FS.add(archeryranges);

		recruitarchers = new JButton("Recruit Archer " + "cost 400");
		recruitarchers.setBounds(0, 180, 500, 50);
		recruitarchers.addActionListener(this);
		FS.add(recruitarchers);

		archeryrangephotos = new JButton();
		archeryrangephotos.setBounds(0, 0, 500, 100);
		archeryrangephotos.setIcon(new ImageIcon(this.getClass().getResource("/archeryrange.png").getFile()));
		archeryrangephotos.setVisible(false);
		FS.add(archeryrangephotos);

		upgradearcheryranges = new JButton("Upgrade Archery Range ");
		upgradearcheryranges.setBounds(0, 130, 500, 50);
		upgradearcheryranges.setVisible(false);
		upgradearcheryranges.addActionListener(this);
		FS.add(upgradearcheryranges);

		stables = new JButton("Construct Stable" + "  cost 2500");
		stables.setBounds(1000, 0, 500, 230);
		stables.addActionListener(this);
		FS.add(stables);

		recruitcavalrys = new JButton("Recruit Cavalry " + "cost 600");
		recruitcavalrys.setBounds(1000, 180, 500, 50);
		recruitcavalrys.addActionListener(this);
		FS.add(recruitcavalrys);

		stablephotos = new JButton();
		stablephotos.setBounds(1000, 0, 500, 100);
		stablephotos.setIcon(new ImageIcon(this.getClass().getResource("/stable.png").getFile()));
		stablephotos.setVisible(false);
		FS.add(stablephotos);

		upgradestables = new JButton("Upgrade Stable ");
		upgradestables.setBounds(1000, 130, 500, 50);
		upgradestables.setVisible(false);
		upgradestables.addActionListener(this);
		FS.add(upgradestables);
		
		viewarmycr = new JButton("View City Army");
		viewarmycr.setBounds(650, 600, 300, 100);
		viewarmycr.addActionListener(this);
		FR.add(viewarmycr);
		
		viewarmycs = new JButton("View City Army");
		viewarmycs.setBounds(650, 600, 300, 100);
		viewarmycs.addActionListener(this);
		FS.add(viewarmycs);
		
		viewarmycc = new JButton("View City Army");
		viewarmycc.setBounds(650, 600, 300, 100);
		viewarmycc.addActionListener(this);
		FC.add(viewarmycc);

		maps = new JButton("Display Map");
		maps.setBounds(1320, 600, 150, 100);
		maps.addActionListener(this);
		FS.add(maps);

		Lss = new JLabel();
		Lss.setBounds(1210, 100, 500, 30);
		FS.add(Lss);

		Las = new JLabel();
		Las.setBounds(192, 100, 500, 30);
		FS.add(Las);

		Lbs = new JLabel();
		Lbs.setBounds(702, 100, 500, 30);
		FS.add(Lbs);

		Lms = new JLabel();
		Lms.setBounds(464, 350, 500, 30);
		FS.add(Lms);

		Lfs = new JLabel();
		Lfs.setBounds(964, 350, 500, 30);
		FS.add(Lfs);

		cl = new JLabel();
		cl.setBounds(750, 0, 5, 5);
		cl.setVisible(false);
		FC.add(cl);

		viewarmy = new JButton("View Defending Army");
		viewarmy.setBounds(950, 600, 300, 100);
		viewarmy.addActionListener(this);
		FC.add(viewarmy);

		viewcity = new JButton("Back To City");
		viewcity.setBounds(1180, 730, 300, 40);
		viewcity.addActionListener(this);
		FA.add(viewcity);

		market = new JButton("Construct Market" + "  cost 1500");
		market.setBounds(250, 250, 500, 200);
		market.addActionListener(this);
		FC.add(market);

		marketphoto = new JButton();
		marketphoto.setBounds(250, 250, 500, 100);
		marketphoto.setIcon(new ImageIcon(this.getClass().getResource("/market.png").getFile()));
		marketphoto.setVisible(false);
		FC.add(marketphoto);

		upgrademarket = new JButton("Upgrade Market");
		upgrademarket.setBounds(250, 380, 500, 70);
		upgrademarket.setVisible(false);
		upgrademarket.addActionListener(this);
		FC.add(upgrademarket);

		farm = new JButton("Construct Farm" + "  cost 1000");
		farm.setBounds(750, 250, 500, 200);
		farm.addActionListener(this);
		FC.add(farm);
		FC.add(new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\farm.png")));

		farmphoto = new JButton();
		farmphoto.setBounds(750, 250, 500, 100);
		farmphoto.setIcon(new ImageIcon(this.getClass().getResource("/farm.png").getFile()));
		farmphoto.setVisible(false);
		FC.add(farmphoto);

		upgradefarm = new JButton("Upgrade Farm ");
		upgradefarm.setBounds(750, 380, 500, 70);
		upgradefarm.setVisible(false);
		upgradefarm.addActionListener(this);
		FC.add(upgradefarm);

		barracks = new JButton("Construct Barracks" + "  cost 2000");
		barracks.setBounds(500, 0, 500, 230);
		barracks.addActionListener(this);
		FC.add(barracks);

		recruitinfantry = new JButton("Recruit Infantry " + "cost 500");
		recruitinfantry.setBounds(500, 180, 500, 50);
		recruitinfantry.addActionListener(this);
		FC.add(recruitinfantry);

		barracksphoto = new JButton();
		barracksphoto.setBounds(500, 0, 500, 100);
		barracksphoto.setIcon(new ImageIcon(this.getClass().getResource("/barracks.png").getFile()));
		barracksphoto.setVisible(false);
		FC.add(barracksphoto);

		upgradebarracks = new JButton("Upgrade Barracks ");
		upgradebarracks.setBounds(500, 130, 500, 50);
		upgradebarracks.setVisible(false);
		upgradebarracks.addActionListener(this);
		FC.add(upgradebarracks);

		archeryrange = new JButton("Construct Archery Range" + "  cost 1500");
		archeryrange.setBounds(0, 0, 500, 230);
		archeryrange.addActionListener(this);
		FC.add(archeryrange);

		recruitarcher = new JButton("Recruit Archer " + "cost 400");
		recruitarcher.setBounds(0, 180, 500, 50);
		recruitarcher.addActionListener(this);
		FC.add(recruitarcher);

		archeryrangephoto = new JButton();
		archeryrangephoto.setBounds(0, 0, 500, 100);
		archeryrangephoto.setIcon(new ImageIcon(this.getClass().getResource("/archeryrange.png").getFile()));
		archeryrangephoto.setVisible(false);
		FC.add(archeryrangephoto);

		upgradearcheryrange = new JButton("Upgrade Archery Range ");
		upgradearcheryrange.setBounds(0, 130, 500, 50);
		upgradearcheryrange.setVisible(false);
		upgradearcheryrange.addActionListener(this);
		FC.add(upgradearcheryrange);

		stable = new JButton("Construct Stable" + "  cost 2500");
		stable.setBounds(1000, 0, 500, 230);
		stable.addActionListener(this);
		FC.add(stable);

		recruitcavalry = new JButton("Recruit Cavalry " + "cost 600");
		recruitcavalry.setBounds(1000, 180, 500, 50);
		recruitcavalry.addActionListener(this);
		FC.add(recruitcavalry);

		stablephoto = new JButton();
		stablephoto.setBounds(1000, 0, 500, 100);
		stablephoto.setIcon(new ImageIcon(this.getClass().getResource("/stable.png").getFile()));
		stablephoto.setVisible(false);
		FC.add(stablephoto);

		upgradestable = new JButton("Upgrade Stable ");
		upgradestable.setBounds(1000, 130, 500, 50);
		upgradestable.setVisible(false);
		upgradestable.addActionListener(this);
		FC.add(upgradestable);

		map = new JButton("Display Map");
		map.setBounds(1320, 600, 150, 100);
		map.addActionListener(this);
		FC.add(map);

		endturn = new JButton("End Turn");
		endturn.setBounds(400, 600, 100, 100);
		endturn.addActionListener(this);
		FC.add(endturn);

		endturnr = new JButton("End Turn");
		endturnr.setBounds(400, 600, 100, 100);
		endturnr.addActionListener(this);
		FR.add(endturnr);

		endturns = new JButton("End Turn");
		endturns.setBounds(400, 600, 100, 100);
		endturns.addActionListener(this);
		FS.add(endturns);

		Ls = new JLabel();
		Ls.setBounds(1210, 100, 500, 30);
		FC.add(Ls);

		La = new JLabel();
		La.setBounds(192, 100, 500, 30);
		FC.add(La);

		Lb = new JLabel();
		Lb.setBounds(702, 100, 500, 30);
		FC.add(Lb);

		Lm = new JLabel();
		Lm.setBounds(464, 350, 500, 30);
		FC.add(Lm);

		Lf = new JLabel();
		Lf.setBounds(964, 350, 500, 30);
		FC.add(Lf);

	}

	public void actionPerformed(ActionEvent e) {
		String city1="";
		if(RB1.isSelected()==true)
			city1="Cairo";
		if(RB2.isSelected()==true)
			city1="Rome";
		if(RB3.isSelected()==true)
			city1="Sparta";
		if (e.getSource() == SG) {
			f1=true;
			f2=true;
			if (playername.getText().equals("")) {
				
				JOptionPane.showMessageDialog(F1, "Please enter your name");
				f1=false;	
			}
			if(!(RB1.isSelected()||RB2.isSelected()||RB3.isSelected())) {
					JOptionPane.showMessageDialog(F1,"A city has to be selected!","!!!",JOptionPane.ERROR_MESSAGE);
					f2=false;
					
			}
			
			if(f1&&f2) {
				F1.dispose();
				String city="";
				if(RB1.isSelected()==true)
					city="Cairo";
				if(RB2.isSelected()==true)
					city="Rome";
				if(RB3.isSelected()==true)
					city="Sparta";
				try {
					game = new Game(playername.getText(), city);
				}
				 catch (IOException e1) {
						e1.printStackTrace();
				}
				F2.add(p);
				F2.add(t);
				F2.add(f);
				F2.add(g);
				
				pv = new JLabel(game.getPlayer().getName());
			    pv.setBounds(160,500,200,50);
				F2.add(pv);
				
				tv = new JLabel(game.getCurrentTurnCount()+"");
			    tv.setBounds(160,550,200,50);
				F2.add(tv);
				
				gv = new JLabel(game.getPlayer().getTreasury()+"");
			    gv.setBounds(160,600,200,50);
				F2.add(gv);
				
				fv = new JLabel(game.getPlayer().getFood()+"");
			    fv.setBounds(160,650,200,50);
				F2.add(fv);
				
				F2.setVisible(true);
				
			}
		}
		else {
			if(e.getSource()== c) {
				for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
					if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("cairo")) {
						citychecker=1;
					}
				}
				if(citychecker==1) {
					cl.setText("Cairo");
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					F2.dispose();
					FC.add(p);
					FC.add(t);
					FC.add(f);
					FC.add(g);
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					FC.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					FC.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					FC.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					FC.add(fv);
					
					FC.setVisible(true);

				}
			}
			if(e.getSource()== r) {
				for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
					if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("rome")) {
						citychecker=2;
					}
				}
				if(citychecker==2) {
					cl.setText("Rome");
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					F2.dispose();
					FR.add(p);
					FR.add(t);
					FR.add(f);
					FR.add(g);
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					FR.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					FR.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					FR.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					FR.add(fv);
					
					FR.setVisible(true);

				}
			}
			if(e.getSource()== s) {
				for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
					if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("sparta")) {
						citychecker=3;
					}
				}
				if(citychecker==3) {
					cl.setText("Sparta");
					//System.out.println(cl.getText());
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					F2.dispose();
					FS.add(p);
					FS.add(t);
					FS.add(f);
					FS.add(g);
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					FS.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					FS.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					FS.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					FS.add(fv);
					
					FS.setVisible(true);
					

				}
			}
			else {
				if(e.getSource()==map) {
					if(game.isGameOver()) {
						F2.dispose();
						FOC.setVisible(true);
					}
					else {
					useiger.setVisible(false);
					useiges.setVisible(false);
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					int j=0;
					int armycounter=1;
					units= new String[200];
					unitss= new String[200];
					armies= new String[200];
					armiesa= new String[200];
					int i = 0;
					
					//for (Army army : game.getPlayer().getControlledArmies()) {
						
					//}

					for(Army army : game.getPlayer().getControlledArmies()) {
						if(army.getUnits().size()>0) {
						armies[j]="Controlled Army "+armycounter;
						armiesa[j]="Controlled Army "+armycounter;
						j++;
						armycounter++;
						}
						//System.out.println(armies[j]);
					}
					for (City city : game.getPlayer().getControlledCities()) {
						for (Unit unit : city.getDefendingArmy().getUnits()) {
								if(unit  instanceof Archer) { 
									units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Cavalry) {
									units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Infantry) {
								    units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
						}
						}
					int b = i;
					int a=1;
					int u=1;
					for (Army army : game.getPlayer().getControlledArmies()) {
						for (Unit unit : army.getUnits()) {
								if(unit  instanceof Archer) { 
									//units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Cavalry) {
									//units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Infantry) {
								    //units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[b] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
						}
						a++;
						u=1;
						}
					cityUnitss = new JComboBox(unitss);
					cityUnitss.setBounds(650,250,400, 40);
					cityUnits = new JComboBox(units);
					cityUnits.setBounds(110, 250, 400, 40);
					coarmies = new JComboBox(armies);
					coarmies.setBounds(650, 300, 200, 40);
					coarmiesa = new JComboBox(armiesa);
					coarmiesa.setBounds(350, 400, 500, 50);
					
					//F2.add(cityUnits);
					//FR.dispose();
					//FS.dispose();
					FC.dispose();
					F2.setVisible(true);
					F2.add(cityUnits);
					F2.add(cityUnitss);
					F2.add(coarmies);
					F2.add(coarmiesa);
					F2.add(p);
					F2.add(t);
					F2.add(f);
					F2.add(g);
					
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Sparta")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useiges.setText("Sparta is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useiges.setVisible(true);
								useiges.setBounds(1118, 150, 400, 40);
								F2.add(useiges);
							}
						}
					}
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Rome")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useiger.setText("Rome is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useiger.setVisible(true);
								useiger.setBounds(718, 150, 400, 40);
								F2.add(useiger);
								
							}
						}
					}
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					F2.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					F2.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					F2.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					F2.add(fv);	
				}
			}
				if(e.getSource()==mapr) {
					if(game.isGameOver()) {
						F2.dispose();
						FOR.setVisible(true);
					}
					else {
					useigec.setVisible(false);
					useiges.setVisible(false);
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					int j=0;
					int armycounter=1;
					units= new String[200];
					unitss= new String[200];
					armies= new String[200];
					armiesa= new String[200];
					int i = 0;
					
					//for (Army army : game.getPlayer().getControlledArmies()) {
						
					//}

					for(Army army : game.getPlayer().getControlledArmies()) {
						if(army.getUnits().size()>0) {
						armies[j]="Controlled Army "+armycounter;
						armiesa[j]="Controlled Army "+armycounter;
						j++;
						armycounter++;
						}
						//System.out.println(armies[j]);
					}
					for (City city : game.getPlayer().getControlledCities()) {
						for (Unit unit : city.getDefendingArmy().getUnits()) {
								if(unit  instanceof Archer) { 
									units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Cavalry) {
									units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Infantry) {
								    units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
						}
						}
					int b = i;
					int a=1;
					int u=1;
					for (Army army : game.getPlayer().getControlledArmies()) {
						for (Unit unit : army.getUnits()) {
								if(unit  instanceof Archer) { 
									//units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Cavalry) {
									//units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Infantry) {
								    //units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[b] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
						}
						a++;
						u=1;
						}
					cityUnitss = new JComboBox(unitss);
					cityUnitss.setBounds(650,250,400, 40);
					cityUnits = new JComboBox(units);
					cityUnits.setBounds(110, 250, 400, 40);
					coarmies = new JComboBox(armies);
					coarmies.setBounds(650, 300, 200, 40);
					coarmiesa = new JComboBox(armiesa);
					coarmiesa.setBounds(350, 400, 500, 50);
					
					//F2.add(cityUnits);
					FR.dispose();
					//FS.dispose();
					//FC.dispose();
					F2.setVisible(true);
					F2.add(cityUnits);
					F2.add(cityUnitss);
					F2.add(coarmies);
					F2.add(coarmiesa);
					F2.add(p);
					F2.add(t);
					F2.add(f);
					F2.add(g);
					
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Sparta")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useiges.setText("Sparta is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useiges.setVisible(true);
								useiges.setBounds(1118, 150, 400, 40);
								F2.add(useiges);
							}
						}
					}
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Cairo")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useigec.setText("Cairo is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useigec.setVisible(true);
								useigec.setBounds(318, 150, 400, 40);
								F2.add(useigec);
								
							}
						}
					}
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					F2.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					F2.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					F2.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					F2.add(fv);	
				}
				}
				if(e.getSource()==maps) {
					if(game.isGameOver()) {
						F2.dispose();
						FOS.setVisible(true);
					}
					else {
					useigec.setVisible(false);
					useiger.setVisible(false);
					cityUnits.setVisible(false);
					cityUnitss.setVisible(false);
					coarmies.setVisible(false);
					coarmiesa.setVisible(false);
					gv.setVisible(false);
					pv.setVisible(false);
					tv.setVisible(false);
					fv.setVisible(false);
					int j=0;
					int armycounter=1;
					units= new String[200];
					unitss= new String[200];
					armies= new String[200];
					armiesa= new String[200];
					int i = 0;
					
					//for (Army army : game.getPlayer().getControlledArmies()) {
						
					//}

					for(Army army : game.getPlayer().getControlledArmies()) {
						if(army.getUnits().size()>0) {
						armies[j]="Controlled Army "+armycounter;
						armiesa[j]="Controlled Army "+armycounter;
						j++;
						armycounter++;
						}
						//System.out.println(armies[j]);
					}
					for (City city : game.getPlayer().getControlledCities()) {
						for (Unit unit : city.getDefendingArmy().getUnits()) {
								if(unit  instanceof Archer) { 
									units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Cavalry) {
									units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
								if(unit instanceof Infantry) {
								    units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									i++;
								}
						}
						}
					int b = i;
					int a=1;
					int u=1;
					for (Army army : game.getPlayer().getControlledArmies()) {
						for (Unit unit : army.getUnits()) {
								if(unit  instanceof Archer) { 
									//units[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Cavalry) {
									//units[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
									unitss[b] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
								if(unit instanceof Infantry) {
								    //units[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
								    unitss[b] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+a+"unit"+u;
									b++;
									u++;
								}
						}
						a++;
						u=1;
						}
					cityUnitss = new JComboBox(unitss);
					cityUnitss.setBounds(650,250,400, 40);
					cityUnits = new JComboBox(units);
					cityUnits.setBounds(110, 250, 400, 40);
					coarmies = new JComboBox(armies);
					coarmies.setBounds(650, 300, 200, 40);
					coarmiesa = new JComboBox(armiesa);
					coarmiesa.setBounds(350, 400, 500, 50);
					
					//F2.add(cityUnits);
					//FR.dispose();
					FS.dispose();
					//FC.dispose();
					F2.setVisible(true);
					F2.add(cityUnits);
					F2.add(cityUnitss);
					F2.add(coarmies);
					F2.add(coarmiesa);
					F2.add(p);
					F2.add(t);
					F2.add(f);
					F2.add(g);
					
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Rome")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useiger.setText("Rome is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useiger.setVisible(true);
								useiger.setBounds(718, 150, 400, 40);
								F2.add(useiger);
							}
						}
					}
					for(City city : game.getAvailableCities()) {
						if(city.getName().equalsIgnoreCase("Cairo")) {
							if(city.getTurnsUnderSiege()>-1 && city.getTurnsUnderSiege()<3) {
								useigec.setText("Cairo is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
								useigec.setVisible(true);
								useigec.setBounds(318, 150, 400, 40);
								F2.add(useigec);
								
							}
						}
					}
					
					pv = new JLabel(game.getPlayer().getName());
				    pv.setBounds(160,500,200,50);
					F2.add(pv);
					
					tv = new JLabel(game.getCurrentTurnCount()+"");
				    tv.setBounds(160,550,200,50);
					F2.add(tv);
					
					gv = new JLabel(game.getPlayer().getTreasury()+"");
				    gv.setBounds(160,600,200,50);
					F2.add(gv);
					
					fv = new JLabel(game.getPlayer().getFood()+"");
				    fv.setBounds(160,650,200,50);
					F2.add(fv);	
				}
				}
				else {
					if(e.getSource()==market) {
						//System.out.println(cl.getText());
						try {
							game.getPlayer().build("market","cairo");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("cairo")) {
									for (EconomicBuilding market : city.getEconomicalBuildings()) {
										if (market instanceof Market) {
											cost = market.getUpgradeCost();
										}
									}
								}
							}
							market.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FC.add(gv);
							Lm.setText("Market level 1");
							marketphoto.setVisible(true);
							upgrademarket.setVisible(true);
							upgrademarket.setText("upgrade cost is "+ cost);
							
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==farm) {
						try {
							game.getPlayer().build("farm","cairo");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("cairo")) {
									for (EconomicBuilding farm : city.getEconomicalBuildings()) {
										if (farm instanceof Farm) {
											cost = farm.getUpgradeCost();
										}
									}
								}
							}
							farm.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FC.add(gv);
							Lf.setText("Farm level 1");
							farmphoto.setVisible(true);
							upgradefarm.setVisible(true);
							upgradefarm.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==stable) {
						try {
							game.getPlayer().build("stable","cairo");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("cairo")) {
									for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
										if (stable instanceof Stable) {
											cost = stable.getUpgradeCost();
										}
									}
								}
							}
							stable.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FC.add(gv);
							Ls.setText("Stable level 1");
							stablephoto.setVisible(true);
							upgradestable.setVisible(true);
							recruitcavalry.setVisible(true);
							upgradestable.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==archeryrange) {
						try {
							game.getPlayer().build("archeryrange","cairo");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("cairo")) {
									for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
										if (archeryrange instanceof ArcheryRange) {
											cost = archeryrange.getUpgradeCost();
										}
									}
								}
							}
							archeryrange.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FC.add(gv);
							La.setText("ArcheryRange level 1");
							archeryrangephoto.setVisible(true);
							upgradearcheryrange.setVisible(true);
							recruitarcher.setVisible(true);
							upgradearcheryrange.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==barracks) {
						try {
							game.getPlayer().build("barracks","cairo");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("cairo")) {
									for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
										if (barracks instanceof Barracks) {
											cost = barracks.getUpgradeCost();
										}
									}
								}
							}
							barracks.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FC.add(gv);
							Lb.setText("Barracks level 1");
							barracksphoto.setVisible(true);
							upgradebarracks.setVisible(true);
							recruitinfantry.setVisible(true);
							upgradebarracks.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}
					
					if(e.getSource()==marketr) {
						//System.out.println(cl.getText());
						try {
							game.getPlayer().build("market", "rome");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("rome")) {
									for (EconomicBuilding market : city.getEconomicalBuildings()) {
										if (market instanceof Market) {
											cost = market.getUpgradeCost();
										}
									}
								}
							}
							marketr.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FR.add(gv);
							Lmr.setText("Market level 1");
							marketphotor.setVisible(true);
							upgrademarketr.setVisible(true);
							upgrademarketr.setText("upgrade cost is "+ cost);
							
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==farmr) {
						try {
							game.getPlayer().build("farm", "rome");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("rome")) {
									for (EconomicBuilding farm : city.getEconomicalBuildings()) {
										if (farm instanceof Farm) {
											cost = farm.getUpgradeCost();
										}
									}
								}
							}
							farmr.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FR.add(gv);
							Lfr.setText("Farm level 1");
							farmphotor.setVisible(true);
							upgradefarmr.setVisible(true);
							upgradefarmr.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==stabler) {
						try {
							game.getPlayer().build("stable","rome");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("rome")) {
									for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
										if (stable instanceof Stable) {
											cost = stable.getUpgradeCost();
										}
									}
								}
							}
							stabler.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FR.add(gv);
							Lsr.setText("Stable level 1");
							stablephotor.setVisible(true);
							upgradestabler.setVisible(true);
							recruitcavalryr.setVisible(true);
							upgradestabler.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==archeryranger) {
						try {
							game.getPlayer().build("archeryrange", "rome");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("rome")) {
									for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
										if (archeryrange instanceof ArcheryRange) {
											cost = archeryrange.getUpgradeCost();
										}
									}
								}
							}
							archeryranger.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FR.add(gv);
							Lar.setText("ArcheryRange level 1");
							archeryrangephotor.setVisible(true);
							upgradearcheryranger.setVisible(true);
							recruitarcherr.setVisible(true);
							upgradearcheryranger.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==barracksr) {
						try {
							game.getPlayer().build("barracks","rome");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("rome")) {
									for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
										if (barracks instanceof Barracks) {
											cost = barracks.getUpgradeCost();
										}
									}
								}
							}
							barracksr.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FR.add(gv);
							Lbr.setText("Barracks level 1");
							barracksphotor.setVisible(true);
							upgradebarracksr.setVisible(true);
							recruitinfantryr.setVisible(true);
							upgradebarracksr.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}
					
					if(e.getSource()==markets) {
						//System.out.println(cl.getText());
						try {
							game.getPlayer().build("market", "sparta");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("sparta")) {
									for (EconomicBuilding market : city.getEconomicalBuildings()) {
										if (market instanceof Market) {
											cost = market.getUpgradeCost();
										}
									}
								}
							}
							markets.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FS.add(gv);
							Lms.setText("Market level 1");
							marketphotos.setVisible(true);
							upgrademarkets.setVisible(true);
							upgrademarkets.setText("upgrade cost is "+ cost);
							
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==farms) {
						try {
							game.getPlayer().build("farm", "sparta");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("sparta")) {
									for (EconomicBuilding farm : city.getEconomicalBuildings()) {
										if (farm instanceof Farm) {
											cost = farm.getUpgradeCost();
										}
									}
								}
							}
							farms.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FS.add(gv);
							Lfs.setText("Farm level 1");
							farmphotos.setVisible(true);
							upgradefarms.setVisible(true);
							upgradefarms.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==stables) {
						try {
							game.getPlayer().build("stable","sparta");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("sparta")) {
									for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
										if (stable instanceof Stable) {
											cost = stable.getUpgradeCost();
										}
									}
								}
							}
							stables.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FS.add(gv);
							Lss.setText("Stable level 1");
							stablephotos.setVisible(true);
							upgradestables.setVisible(true);
							recruitcavalrys.setVisible(true);
							upgradestables.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==archeryranges) {
						try {
							game.getPlayer().build("archeryrange","sparta");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("sparta")) {
									for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
										if (archeryrange instanceof ArcheryRange) {
											cost = archeryrange.getUpgradeCost();
										}
									}
								}
							}
							archeryranges.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FS.add(gv);
							Las.setText("ArcheryRange level 1");
							archeryrangephotos.setVisible(true);
							upgradearcheryranges.setVisible(true);
							recruitarchers.setVisible(true);
							upgradearcheryranges.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!" ,JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}if(e.getSource()==barrackss) {
						try {
							game.getPlayer().build("barracks","sparta");
							int cost=0;
							for (City city : game.getPlayer().getControlledCities()) {
								if (city.getName().toLowerCase().equals("sparta")) {
									for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
										if (barracks instanceof Barracks) {
											cost = barracks.getUpgradeCost();
										}
									}
								}
							}
							barrackss.setVisible(false);
							gv.setText(game.getPlayer().getTreasury()+"");
							FS.add(gv);
							Lbs.setText("Barracks level 1");
							barracksphotos.setVisible(true);
							upgradebarrackss.setVisible(true);
							recruitinfantrys.setVisible(true);
							upgradebarrackss.setText("upgrade cost is "+ cost);
						} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}
					
					
					
					else {
						if (e.getSource() == upgradefarm) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("cairo")) {
										for (EconomicBuilding farm : city.getEconomicalBuildings()) {
											if (farm instanceof Farm) {
												game.getPlayer().upgradeBuilding(farm);
												cost = farm.getUpgradeCost();
												level=farm.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								if(level==3)
									upgradefarm.setText("Upgrade");
								else
									upgradefarm.setText("upgrade cost is "+ cost);
								Lf.setText("Farm level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FC,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgrademarket) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("cairo")) {
										for (EconomicBuilding market : city.getEconomicalBuildings()) {
											if (market instanceof Market) {
												game.getPlayer().upgradeBuilding(market);
												cost = market.getUpgradeCost();
												level=market.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								if(level==3)
									upgrademarket.setText("Upgrade");
								else
									upgrademarket.setText("upgrade cost is "+ cost);
								Lm.setText("Market level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FC,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradearcheryrange) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("cairo")) {
										for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
											if (archeryrange instanceof ArcheryRange) {
												game.getPlayer().upgradeBuilding(archeryrange);
												cost = archeryrange.getUpgradeCost();
												level=archeryrange.getLevel();
												recruitcost=archeryrange.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								if(level==3)
									upgradearcheryrange.setText("Upgrade");
								else
									upgradearcheryrange.setText("upgrade cost is "+ cost);
								La.setText("Archery Range level "+level);
								recruitarcher.setText("Recruit Archer "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FC,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradebarracks) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("cairo")) {
										for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
											if (barracks instanceof Barracks) {
												game.getPlayer().upgradeBuilding(barracks);
												cost = barracks.getUpgradeCost();
												level=barracks.getLevel();
												recruitcost=barracks.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								if(level==3)
									upgradebarracks.setText("Upgrade");
								else
									upgradebarracks.setText("upgrade cost is "+ cost);
								Lb.setText("Barracks level "+level);
								recruitinfantry.setText("Recruit Infantry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FC,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradestable) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("cairo")) {
										for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
											if (stable instanceof Stable) {
												game.getPlayer().upgradeBuilding(stable);
												cost = stable.getUpgradeCost();
												level=stable.getLevel();
												recruitcost=stable.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								if(level==3)
									upgradestable.setText("Upgrade");
								else
									upgradestable.setText("upgrade cost is "+ cost);
								Ls.setText("Stable level "+level);
								recruitcavalry.setText("Recruit Cavalry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FC,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						
						if (e.getSource() == upgradefarmr) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("rome")) {
										for (EconomicBuilding farm : city.getEconomicalBuildings()) {
											if (farm instanceof Farm) {
												game.getPlayer().upgradeBuilding(farm);
												cost = farm.getUpgradeCost();
												level=farm.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								if(level==3)
									upgradefarmr.setText("Upgrade");
								else
									upgradefarmr.setText("upgrade cost is "+ cost);
								Lfr.setText("Farm level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FR,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgrademarketr) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("rome")) {
										for (EconomicBuilding market : city.getEconomicalBuildings()) {
											if (market instanceof Market) {
												game.getPlayer().upgradeBuilding(market);
												cost = market.getUpgradeCost();
												level=market.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								if(level==3)
									upgrademarketr.setText("Upgrade");
								else
									upgrademarketr.setText("upgrade cost is "+ cost);
								Lmr.setText("Market level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FR,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradearcheryranger) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("rome")) {
										for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
											if (archeryrange instanceof ArcheryRange) {
												game.getPlayer().upgradeBuilding(archeryrange);
												cost = archeryrange.getUpgradeCost();
												level=archeryrange.getLevel();
												recruitcost=archeryrange.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								if(level==3)
									upgradearcheryranger.setText("Upgrade");
								else
									upgradearcheryranger.setText("upgrade cost is "+ cost);
								Lar.setText("Archery Range level "+level);
								recruitarcherr.setText("Recruit Archer "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FR,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradebarracksr) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("rome")) {
										for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
											if (barracks instanceof Barracks) {
												game.getPlayer().upgradeBuilding(barracks);
												cost = barracks.getUpgradeCost();
												level=barracks.getLevel();
												recruitcost=barracks.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								if(level==3)
									upgradebarracksr.setText("Upgrade");
								else
									upgradebarracksr.setText("upgrade cost is "+ cost);
								Lbr.setText("Barracks level "+level);
								recruitinfantryr.setText("Recruit Infantry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FR,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradestabler) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("rome")) {
										for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
											if (stable instanceof Stable) {
												game.getPlayer().upgradeBuilding(stable);
												cost = stable.getUpgradeCost();
												level=stable.getLevel();
												recruitcost=stable.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								if(level==3)
									upgradestabler.setText("Upgrade");
								else
									upgradestabler.setText("upgrade cost is "+ cost);
								Lsr.setText("Stable level "+level);
								recruitcavalryr.setText("Recruit Cavalry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FR,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						
						if (e.getSource() == upgradefarms) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("sparta")) {
										for (EconomicBuilding farm : city.getEconomicalBuildings()) {
											if (farm instanceof Farm) {
												game.getPlayer().upgradeBuilding(farm);
												cost = farm.getUpgradeCost();
												level=farm.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								if(level==3)
									upgradefarms.setText("Upgrade");
								else
									upgradefarms.setText("upgrade cost is "+ cost);
								Lfs.setText("Farm level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FS,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgrademarkets) {
							try {
								int cost = 0;
								int level=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("sparta")) {
										for (EconomicBuilding market : city.getEconomicalBuildings()) {
											if (market instanceof Market) {
												game.getPlayer().upgradeBuilding(market);
												cost = market.getUpgradeCost();
												level=market.getLevel();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								if(level==3)
									upgrademarkets.setText("Upgrade");
								else
									upgrademarkets.setText("upgrade cost is "+ cost);
								Lms.setText("Market level "+level);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FS,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradearcheryranges) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("sparta")) {
										for (MilitaryBuilding archeryrange : city.getMilitaryBuildings()) {
											if (archeryrange instanceof ArcheryRange) {
												game.getPlayer().upgradeBuilding(archeryrange);
												cost = archeryrange.getUpgradeCost();
												level=archeryrange.getLevel();
												recruitcost=archeryrange.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								if(level==3)
									upgradearcheryranges.setText("Upgrade");
								else
									upgradearcheryranges.setText("upgrade cost is "+ cost);
								Las.setText("Archery Range level "+level);
								recruitarchers.setText("Recruit Archer "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FS,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradebarrackss) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("sparta")) {
										for (MilitaryBuilding barracks : city.getMilitaryBuildings()) {
											if (barracks instanceof Barracks) {
												game.getPlayer().upgradeBuilding(barracks);
												cost = barracks.getUpgradeCost();
												level=barracks.getLevel();
												recruitcost=barracks.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								if(level==3)
									upgradebarrackss.setText("Upgrade");
								else
									upgradebarrackss.setText("upgrade cost is "+ cost);
								Lbs.setText("Barracks level "+level);
								recruitinfantrys.setText("Recruit Infantry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FS,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						if (e.getSource() == upgradestables) {
							try {
								int cost = 0;
								int level=0;
								int recruitcost=0;
								for (City city : game.getPlayer().getControlledCities()) {
									if (city.getName().toLowerCase().equals("sparta")) {
										for (MilitaryBuilding stable : city.getMilitaryBuildings()) {
											if (stable instanceof Stable) {
												game.getPlayer().upgradeBuilding(stable);
												cost = stable.getUpgradeCost();
												level=stable.getLevel();
												recruitcost=stable.getRecruitmentCost();
											}
										}
									}
								}
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								if(level==3)
									upgradestables.setText("Upgrade");
								else
									upgradestables.setText("upgrade cost is "+ cost);
								Lss.setText("Stable level "+level);
								recruitcavalrys.setText("Recruit Cavalry "+"cost "+recruitcost);

							} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (MaxLevelException e1) {JOptionPane.showMessageDialog(FS,"maxLevel reahced ","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
						}
						
						else {
							if(e.getSource() == endturn) {
								game.endTurn();
								gv.setText(game.getPlayer().getTreasury()+"");
								FC.add(gv);
								tv.setText(game.getCurrentTurnCount()+"");
								FC.add(tv);
								fv.setText(game.getPlayer().getFood()+"");
								FC.add(fv);
								FC.setVisible(true);
								for(City city: game.getAvailableCities()) {
									if(city.getName().equalsIgnoreCase("Rome")) {
										if(city.getTurnsUnderSiege()==3) {
											FC.dispose();
											FFR.setVisible(true);
										}
									}
									if(city.getName().equalsIgnoreCase("Sparta")) {
										if(city.getTurnsUnderSiege()==3) {
											FC.dispose();
											FFS.setVisible(true);
										}
									}
								}
								if(game.isGameOver()) {
									FC.dispose();
									FOC.setVisible(true);
								}
							
							}
							if(e.getSource() == endturnr) {
								game.endTurn();
								gv.setText(game.getPlayer().getTreasury()+"");
								FR.add(gv);
								tv.setText(game.getCurrentTurnCount()+"");
								FR.add(tv);
								fv.setText(game.getPlayer().getFood()+"");
								FR.add(fv);
								FR.setVisible(true);
								for(City city: game.getAvailableCities()) {
									if(city.getName().equalsIgnoreCase("Cairo")) {
										if(city.getTurnsUnderSiege()==3) {
											FR.dispose();
											FFC.setVisible(true);
										}
									}
									if(city.getName().equalsIgnoreCase("Sparta")) {
										if(city.getTurnsUnderSiege()==3) {
											FR.dispose();
											FFS.setVisible(true);
										}
									}
								}
								if(game.isGameOver()) {
									FR.dispose();
									FOR.setVisible(true);
								}
							}
							
							if(e.getSource() == endturns) {
								game.endTurn();
								gv.setText(game.getPlayer().getTreasury()+"");
								FS.add(gv);
								tv.setText(game.getCurrentTurnCount()+"");
								FS.add(tv);
								fv.setText(game.getPlayer().getFood()+"");
								FS.add(fv);
								FS.setVisible(true);
								for(City city: game.getAvailableCities()) {
									if(city.getName().equalsIgnoreCase("Cairo")) {
										if(city.getTurnsUnderSiege()==3) {
											FS.dispose();
											FFC.setVisible(true);
										}
									}
									if(city.getName().equalsIgnoreCase("Rome")) {
										if(city.getTurnsUnderSiege()==3) {
											FS.dispose();
											FFR.setVisible(true);
										}
									}
								}
								if(game.isGameOver()) {
									FS.dispose();
									FOS.setVisible(true);
								}
							}
							
							else {
								if (e.getSource() == recruitarcher) {
									try {
										game.getPlayer().recruitUnit("archer","cairo");
										gv.setText(game.getPlayer().getTreasury()+"");
										FC.add(gv);
										//System.out.print(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size());
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC,"City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FC,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitinfantry) {
									try {
										game.getPlayer().recruitUnit("infantry","cairo");
										gv.setText(game.getPlayer().getTreasury()+"");
										FC.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FC,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitcavalry) {
									try {
										game.getPlayer().recruitUnit("cavalry","cairo");
										gv.setText(game.getPlayer().getTreasury()+"");
										FC.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FC, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FC,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FC,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								
								if (e.getSource() == recruitarchers) {
									try {
										game.getPlayer().recruitUnit("archer","sparta");
										gv.setText(game.getPlayer().getTreasury()+"");
										FS.add(gv);
										//System.out.print(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size());
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS,"City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FS,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitinfantrys) {
									try {
										game.getPlayer().recruitUnit("infantry","sparta");
										gv.setText(game.getPlayer().getTreasury()+"");
										FS.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FS,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitcavalrys) {
									try {
										game.getPlayer().recruitUnit("cavalry","sparta");
										gv.setText(game.getPlayer().getTreasury()+"");
										FS.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FS, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FS,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FS,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								
								if (e.getSource() == recruitarcherr) {
									try {
										game.getPlayer().recruitUnit("archer","rome");
										gv.setText(game.getPlayer().getTreasury()+"");
										FR.add(gv);
										//System.out.print(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size());
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR,"City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FR,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitinfantryr) {
									try {
										game.getPlayer().recruitUnit("infantry","rome");
										gv.setText(game.getPlayer().getTreasury()+"");
										FR.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FR,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								if (e.getSource() == recruitcavalryr) {
									try {
										game.getPlayer().recruitUnit("cavalry","rome");
										gv.setText(game.getPlayer().getTreasury()+"");
										FR.add(gv);
									} catch (BuildingInCoolDownException e1) {JOptionPane.showMessageDialog(FR, "City is in cooldown ","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (MaxRecruitedException e1) {JOptionPane.showMessageDialog(FR,"Max recruited units reached, please wait till next turn. ","!!!",JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(FR,"Gold Needed","!!!", JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
								}
								
								else {
									if(e.getSource()== viewarmy) {
										//unitcounter=0;
										archerX=0;
										infantryX=0;
										cavalryX=0;
										archerY=0;
										infantryY=0;
										cavalryY=0;
										FA = new JFrame();
										FA.setSize(1500,810);
										FA.getContentPane().setLayout(null);
										FA.setVisible(false);
										FA.setResizable(false);
										FA.add(viewcity);
									for(City city : game.getPlayer().getControlledCities()) {
										if(city.getName().equalsIgnoreCase("cairo")) {
										for(Unit unit :city.getDefendingArmy().getUnits()) {
											if(unit instanceof Archer ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+archerX, 40+archerY, 50, 20);
												FA.add(sj);
												JLabel archerl=new JLabel("level "+level);
												archerl.setBounds(32+archerX, 20+archerY, 50, 20);
												FA.add(archerl);
												archer=new JButton();
												//archer.addActionListener(this);
												archer.setBounds(25+archerX, 60+archerY, 50, 50);
												archer.setIcon(new ImageIcon(this.getClass().getResource("/archer.png").getFile()));
												FA.add(archer);
												archer.setVisible(true);
												archerX+=50;
												if(archerX==1450) {
													archerX=0;
													archerY+=100;
												}
												//System.out.print(archer.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Infantry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+infantryX, 290+infantryY, 50, 20);
												FA.add(sj);
												JLabel infantryl=new JLabel("level "+level);
												infantryl.setBounds(32+infantryX, 270+infantryY, 50, 20);
												FA.add(infantryl);
												JButton infantry=new JButton();
												infantry.setBounds(25+infantryX, 310+infantryY, 50, 50);
												infantry.setIcon(new ImageIcon(this.getClass().getResource("/infantry.png").getFile()));
												FA.add(infantry);
												infantry.setVisible(true);
												infantryX+=50;
												if(infantryX==1450) {
													infantryX=0;
													infantryY+=100;
												}
												//System.out.print(infantry.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Cavalry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+cavalryX, 540+cavalryY, 50, 20);
												FA.add(sj);
												JLabel cavalryl=new JLabel("level "+level);
												cavalryl.setBounds(32+cavalryX, 520+cavalryY, 50, 20);
												FA.add(cavalryl);
												JButton cavalry=new JButton();
												cavalry.setBounds(25+cavalryX, 560+cavalryY, 50, 50);
												cavalry.setIcon(new ImageIcon(this.getClass().getResource("/cavalry.png").getFile()));
												FA.add(cavalry);
												cavalry.setVisible(true);
												cavalryX+=50;
												if(cavalryX==1450) {
													cavalryX=0;
													cavalryY+=100;
												}
												//System.out.print(cavalry.getText());
												//unitcounter+=1;
												
											}
										}
										}
									}
										FC.dispose();
										//FA.setVisible(true);
										FA.setVisible(true);
									}
									
									if(e.getSource()== viewarmyr) {
										//unitcounter=0;
										archerX=0;
										infantryX=0;
										cavalryX=0;
										archerY=0;
										infantryY=0;
										cavalryY=0;
										FAR = new JFrame();
										FAR.setSize(1500,810);
										FAR.getContentPane().setLayout(null);
										FAR.setVisible(false);
										FAR.setResizable(false);
										FAR.add(viewcityr);
									for(City city : game.getPlayer().getControlledCities()) {
										if(city.getName().equalsIgnoreCase("rome")) {
										for(Unit unit :city.getDefendingArmy().getUnits()) {
											if(unit instanceof Archer ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+archerX, 40+archerY, 50, 20);
												FAR.add(sj);
												JLabel archerl=new JLabel("level "+level);
												archerl.setBounds(32+archerX, 20+archerY, 50, 20);
												FAR.add(archerl);
												archer=new JButton();
												//archer.addActionListener(this);
												archer.setBounds(25+archerX, 60+archerY, 50, 50);
												archer.setIcon(new ImageIcon(this.getClass().getResource("/archer.png").getFile()));
												FAR.add(archer);
												archer.setVisible(true);
												archerX+=50;
												if(archerX==1450) {
													archerX=0;
													archerY+=100;
												}
												//System.out.print(archer.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Infantry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+infantryX, 290+infantryY, 50, 20);
												FAR.add(sj);
												JLabel infantryl=new JLabel("level "+level);
												infantryl.setBounds(32+infantryX, 270+infantryY, 50, 20);
												FAR.add(infantryl);
												JButton infantry=new JButton();
												infantry.setBounds(25+infantryX, 310+infantryY, 50, 50);
												infantry.setIcon(new ImageIcon(this.getClass().getResource("/infantry.png").getFile()));
												FAR.add(infantry);
												infantry.setVisible(true);
												infantryX+=50;
												if(infantryX==1450) {
													infantryX=0;
													infantryY+=100;
												}
												//System.out.print(infantry.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Cavalry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+cavalryX, 540+cavalryY, 50, 20);
												FAR.add(sj);
												JLabel cavalryl=new JLabel("level "+level);
												cavalryl.setBounds(32+cavalryX, 520+cavalryY, 50, 10);
												FAR.add(cavalryl);
												JButton cavalry=new JButton();
												cavalry.setBounds(25+cavalryX, 560+cavalryY, 50, 50);
												cavalry.setIcon(new ImageIcon(this.getClass().getResource("/cavalry.png").getFile()));
												FAR.add(cavalry);
												cavalry.setVisible(true);
												cavalryX+=50;
												if(cavalryX==1450) {
													cavalryX=0;
													cavalryY+=100;
												}
												//System.out.print(cavalry.getText());
												//unitcounter+=1;
												
											}
										}
										}
									}
										FR.dispose();
										//FA.setVisible(true);
										FAR.setVisible(true);
									}
									
									if(e.getSource()== viewarmys) {
										//unitcounter=0;
										archerX=0;
										infantryX=0;
										cavalryX=0;
										archerY=0;
										infantryY=0;
										cavalryY=0;
										FAS = new JFrame();
										FAS.setSize(1500,810);
										FAS.getContentPane().setLayout(null);
										FAS.setVisible(false);
										FAS.setResizable(false);
										FAS.add(viewcitys);
									for(City city : game.getPlayer().getControlledCities()) {
										if(city.getName().equalsIgnoreCase("sparta")) {
										for(Unit unit :city.getDefendingArmy().getUnits()) {
											if(unit instanceof Archer ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+archerX, 40+archerY, 50, 20);
												FAS.add(sj);
												JLabel archerl=new JLabel("level "+level);
												archerl.setBounds(32+archerX, 20+archerY, 50, 20);
												FAS.add(archerl);
												archer=new JButton();
												archer.addActionListener(this);
												archer.setBounds(25+archerX, 60+archerY, 50, 50);
												archer.setIcon(new ImageIcon(this.getClass().getResource("/archer.png").getFile()));
												FAS.add(archer);
												archer.setVisible(true);
												archerX+=50;
												if(archerX==1450) {
													archerX=0;
													archerY+=100;
												}
												//System.out.print(archer.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Infantry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+infantryX, 290+infantryY, 50, 20);
												FAS.add(sj);
												JLabel infantryl=new JLabel("level "+level);
												infantryl.setBounds(32+infantryX, 270+infantryY, 50, 20);
												FAS.add(infantryl);
												JButton infantry=new JButton();
												infantry.setBounds(25+infantryX, 310+infantryY, 50, 50);
												infantry.setIcon(new ImageIcon(this.getClass().getResource("/infantry.png").getFile()));
												FAS.add(infantry);
												infantry.setVisible(true);
												infantryX+=50;
												if(infantryX==1450) {
													infantryX=0;
													infantryY+=100;
												}
												//System.out.print(infantry.getText());
												//unitcounter+=1;
												
											}
											if(unit instanceof Cavalry ) {
												int level=unit.getLevel();
												int csc=unit.getCurrentSoldierCount();
												JLabel sj=new JLabel(csc+"/"+unit.getMaxSoldierCount());
												sj.setBounds(35+cavalryX, 540+cavalryY, 50, 20);
												FAS.add(sj);
												JLabel cavalryl=new JLabel("level "+level);
												cavalryl.setBounds(32+cavalryX, 520+cavalryY, 50, 20);
												FAS.add(cavalryl);
												JButton cavalry=new JButton();
												cavalry.setBounds(25+cavalryX, 560+cavalryY, 50, 50);
												cavalry.setIcon(new ImageIcon(this.getClass().getResource("/cavalry.png").getFile()));
												FAS.add(cavalry);
												cavalry.setVisible(true);
												cavalryX+=50;
												if(cavalryX==1450) {
													cavalryX=0;
													cavalryY+=100;
												}
												//System.out.print(cavalry.getText());
												//unitcounter+=1;
												
											}
										}
										}
									}
										FS.dispose();
										//FA.setVisible(true);
										FAS.setVisible(true);
									}
									
									else {
										if(e.getSource()== viewcity) {
											FA.dispose();
											FC.setVisible(true);
											//System.out.print(archer.getText());
										}
										if(e.getSource()== viewcityr) {
											FAR.dispose();
											FR.setVisible(true);
											//System.out.print(archer.getText());
										}
										if(e.getSource()== viewcitys) {
											FAS.dispose();
											FS.setVisible(true);
											//System.out.print(archer.getText());
										}
										else {
											if(e.getSource()==inarmy) {
												if(cityUnits.getSelectedItem()!=null) {
												for (City city : game.getPlayer().getControlledCities()) {
													if (city.getName().charAt(city.getName().length()-1)==units[cityUnits.getSelectedIndex()].charAt(units[cityUnits.getSelectedIndex()].length()-1)) {
															game.getPlayer().initiateArmy(city, city.getDefendingArmy().getUnits().get(cityUnits.getSelectedIndex()));
															if(city.getName().equalsIgnoreCase("Cairo")) {
																c.doClick();
																map.doClick();
															}
															if(city.getName().equalsIgnoreCase("Rome")) {
																r.doClick();
																mapr.doClick();
															}
															if(city.getName().equalsIgnoreCase("Sparta")) {
																s.doClick();
																maps.doClick();
															}
															//System.out.println(5);
													}
															
												}		
												}
												else {
													JOptionPane.showMessageDialog(F2,"You must recruit unit first");
												}
											}
											else {
												if(e.getSource()==reunit) {
													if(cityUnitss.getSelectedItem()!=null) {
														flagg=false;
													for (City city : game.getPlayer().getControlledCities()) {
														if (city.getName().charAt(city.getName().length()-1)==unitss[cityUnitss.getSelectedIndex()].charAt(unitss[cityUnitss.getSelectedIndex()].length()-1)) {
															flagg=true;
													    int count = 0;
														for(int i = 0 ; i < unitss.length;i++) {
													    	if(unitss[i].charAt(unitss[i].length()-1) != city.getName().charAt(city.getName().length() -1)){
													    				count++;
													    	}
													    	else
													    		break;
													    }
														if((city.getDefendingArmy().getUnits().get(cityUnitss.getSelectedIndex()-count)).getParentArmy().getCurrentLocation().equalsIgnoreCase(game.getPlayer().getControlledArmies().get(coarmies.getSelectedIndex()).getCurrentLocation())) {
															
															try {
														game.getPlayer().getControlledArmies().get(coarmies.getSelectedIndex()).relocateUnit(city.getDefendingArmy().getUnits().get(cityUnitss.getSelectedIndex()-count));
														if(city.getName().equalsIgnoreCase("Cairo")) {
															c.doClick();
															map.doClick();
														}
														if(city.getName().equalsIgnoreCase("Rome")) {
															r.doClick();
															mapr.doClick();
														}
														if(city.getName().equalsIgnoreCase("Sparta")) {
															s.doClick();
															maps.doClick();
														}
													} catch (MaxCapacityException e1) {JOptionPane.showMessageDialog(F2, "Maximum capacity reached","!!!",JOptionPane.WARNING_MESSAGE);
														e1.printStackTrace();
													}
														}
														else {
															JOptionPane.showMessageDialog(F2,"Locations of Army and Unit are different");
														}
												}
													}
														
														if(flagg==false) {
															int q=Integer.parseInt(String.valueOf(unitss[cityUnitss.getSelectedIndex()].charAt(unitss[cityUnitss.getSelectedIndex()].length()-1)))-1;
															if(q==-1)
																q=9;
															int t=Integer.parseInt(String.valueOf(unitss[cityUnitss.getSelectedIndex()].charAt(unitss[cityUnitss.getSelectedIndex()].length()-6)))-1;
															if(q==9)
																t=Integer.parseInt(String.valueOf(unitss[cityUnitss.getSelectedIndex()].charAt(unitss[cityUnitss.getSelectedIndex()].length()-7)))-1;
	
															if(game.getPlayer().getControlledArmies().get(coarmies.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase(game.getPlayer().getControlledArmies().get(t).getUnits().get(q).getParentArmy().getCurrentLocation())) {
													try {
														game.getPlayer().getControlledArmies().get(coarmies.getSelectedIndex()).relocateUnit(game.getPlayer().getControlledArmies().get(t).getUnits().get(q));
														if(city1.equalsIgnoreCase("Cairo")) {
															c.doClick();
															map.doClick();
														}
														if(city1.equalsIgnoreCase("Rome")) {
															r.doClick();
															mapr.doClick();
														}
														if(city1.equalsIgnoreCase("Sparta")) {
															s.doClick();
															maps.doClick();
														}
													}catch (MaxCapacityException e1) {JOptionPane.showMessageDialog(F2, "Maximum capacity reached","!!!",JOptionPane.WARNING_MESSAGE);
														e1.printStackTrace();	
													}
															}
															else {
																JOptionPane.showMessageDialog(F2,"Locations of Army and Unit are different");
															}
														}
													}
												
													else {
														JOptionPane.showMessageDialog(F2,"You must recruit unit first");
													}
												}
												else {
													if(e.getSource()==attackc) {
														if(game.getPlayer().getControlledArmies().size()>0 && (game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0 || flagoo1)) {
															flagoo1=false;
														for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
															if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("cairo")) {
																checkc=true;
															}
														}
													if(checkc==false) {
														if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("cairo")) {
														mbutton.setVisible(false);
														ll.setText("cairo");
														//City defendcity=null;
														lcairo.setText("cairo");
														attackuc.setVisible(false);
														defenduc.setVisible(false);
														attacku= new String[100];
														defendu= new String[100];
														int index=coarmiesa.getSelectedIndex();
														int index1=index+1;
														int z=0;
														int y=0;
														int w=1;
														for(Unit unit : game.getPlayer().getControlledArmies().get(index).getUnits()) {
															if(unit  instanceof Archer) { 
																attacku[z] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Cavalry) {
																attacku[z] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Infantry) {
																attacku[z] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
															   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
														}
														for(City city : game.getAvailableCities()) {
															if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																for(Unit unit : city.getDefendingArmy().getUnits()) {
																	if(unit  instanceof Archer) { 
																		defendu[y] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" cairo";
																		//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Cavalry) {
																		defendu[y] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" cairo";
																		//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Infantry) {
																		defendu[y] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" cairo";
																	   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																}
															}
														}
														
														attackuc = new JComboBox(attacku);
														attackuc.setBounds(100, 100, 400, 50);
														defenduc = new JComboBox(defendu);
														defenduc.setBounds(1000, 100, 400, 50);
														F2.dispose();
														FB.setVisible(true);
														FB.add(attackuc);
														FB.add(defenduc);
													}
														else {
															JOptionPane.showMessageDialog(F2,"Target Not Reached");
														}
													}
													else {
														JOptionPane.showMessageDialog(F2,"You cannot attack a friendly city");
													}
													}
														else {
															JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
														}
												}
													if(e.getSource()==attackr) {
														if(game.getPlayer().getControlledArmies().size()>0 && (game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0 || flagoo2)) {
															flagoo2=false;
														for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
															if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("rome")) {
																checkr=true;
															}
														}
													if(checkr==false) {
														if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("rome")) {
														mbutton.setVisible(false);
														ll.setText("rome");
														//City defendcity=null;
														lcairo.setText("rome");
														attackuc.setVisible(false);
														defenduc.setVisible(false);
														attacku= new String[100];
														defendu= new String[100];
														int index=coarmiesa.getSelectedIndex();
														int index1=index+1;
														int z=0;
														int y=0;
														int w=1;
														for(Unit unit : game.getPlayer().getControlledArmies().get(index).getUnits()) {
															if(unit  instanceof Archer) { 
																attacku[z] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Cavalry) {
																attacku[z] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Infantry) {
																attacku[z] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
															   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
														}
														for(City city : game.getAvailableCities()) {
															if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																for(Unit unit : city.getDefendingArmy().getUnits()) {
																	if(unit  instanceof Archer) { 
																		defendu[y] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" rome";
																		//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Cavalry) {
																		defendu[y] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" rome";
																		//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Infantry) {
																		defendu[y] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" rome";
																	   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																}
																
															}
														}
														
														attackuc = new JComboBox(attacku);
														attackuc.setBounds(100, 100, 400, 50);
														defenduc = new JComboBox(defendu);
														defenduc.setBounds(1000, 100, 400, 50);
														F2.dispose();
														FBR.setVisible(true);
														FBR.add(attackuc);
														FBR.add(defenduc);
													}
														else {
															JOptionPane.showMessageDialog(F2,"Target Not Reached");
														}
													}
													else {
														JOptionPane.showMessageDialog(F2,"You cannot attack a friendly city");
													}
													}
														else {
															JOptionPane.showMessageDialog(F2,"You must initiate army first within units");	
														}
												}
													if(e.getSource()==attacks) {
														if(game.getPlayer().getControlledArmies().size()>0 && (game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0 || flagoo1)) {
															flagoo3=false;
														for (int i = game.getPlayer().getControlledCities().size()-1; i >=0; i--) {
															if (game.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals("sparta")) {
																checks=true;
															}
														}
													if(checks==false) {
														if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("sparta")) {
														mbutton.setVisible(false);
														ll.setText("sparta");
														//City defendcity=null;
														lcairo.setText("sparta");
														attackuc.setVisible(false);
														defenduc.setVisible(false);
														attacku= new String[100];
														defendu= new String[100];
														int index=coarmiesa.getSelectedIndex();
														int index1=index+1;
														int z=0;
														int y=0;
														int w=1;
														for(Unit unit : game.getPlayer().getControlledArmies().get(index).getUnits()) {
															if(unit  instanceof Archer) { 
																attacku[z] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Cavalry) {
																attacku[z] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
																//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
															if(unit instanceof Infantry) {
																attacku[z] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+"Army"+index1+"Unit"+w;
															   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																z++;
																w++;
															}
														}
														for(City city : game.getAvailableCities()) {
															if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																for(Unit unit : city.getDefendingArmy().getUnits()) {
																	if(unit  instanceof Archer) { 
																		defendu[y] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" sparta";
																		//unitss[i] = "Archer "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Cavalry) {
																		defendu[y] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" sparta";
																		//unitss[i] = "Cavalry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																	if(unit instanceof Infantry) {
																		defendu[y] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" sparta";
																	   // unitss[i] = "Infantry "+"level "+unit.getLevel()+" CurrenSoldiersCount : "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount()+" "+city.getName();
																		y++;
																	}
																}
																
															}
														}
														
														
														attackuc = new JComboBox(attacku);
														attackuc.setBounds(100, 100, 400, 50);
														defenduc = new JComboBox(defendu);
														defenduc.setBounds(1000, 100, 400, 50);
														F2.dispose();
														FBS.setVisible(true);
														FBS.add(attackuc);
														FBS.add(defenduc);
													}
														else {
															JOptionPane.showMessageDialog(F2,"Target Not Reached");
														}
													}
													else {
														JOptionPane.showMessageDialog(F2,"You cannot attack a friendly city");
													}
													}
														else {
															JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
														}
													}
													else {
														if(e.getSource()==startbattle) {
															mbutton.setVisible(false);
															soldier1.setVisible(false);
															soldier2.setVisible(false);
															attackerc.setVisible(true);	
															String type1="";
															String type2="";
															int q=attackuc.getSelectedIndex();
															int r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1;
															if(q==9)
																r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-7)))-1;
															buttonatt.setVisible(false);
															buttondef.setVisible(false);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-1)))-1);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1);
															att=game.getPlayer().getControlledArmies().get(r).getUnits().get(q);
															for(City city : game.getAvailableCities()) {
																if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																	def=city.getDefendingArmy().getUnits().get(defenduc.getSelectedIndex());
																}
															}
															if(att instanceof Archer) {
																type1="Archer";
																soldier1.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1.setVisible(true);
																buttonatt=new JButton();
																buttonatt.setBounds(200, 400, 300, 350);
																buttonatt.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttonatt.setVisible(true);
																FB.add(buttonatt);
															}
															if(att instanceof Infantry) {
																type1="Infantry";
																soldier1.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1.setVisible(true);
																buttonatt=new JButton();
																buttonatt.setBounds(200, 400, 300, 350);
																buttonatt.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttonatt.setVisible(true);
																FB.add(buttonatt);
															}
															if(att instanceof Cavalry) {
																type1="Cavalry";
																soldier1.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1.setVisible(true);
																buttonatt=new JButton();
																buttonatt.setBounds(200, 400, 300, 350);
																buttonatt.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttonatt.setVisible(true);
																FB.add(buttonatt);
															}
															if(def instanceof Archer) {
																type2="Archer";
																soldier2.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2.setVisible(true);
																buttondef=new JButton();
																buttondef.setBounds(1000, 400, 300, 350);
																buttondef.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttondef.setVisible(true);
																FB.add(buttondef);
															}
															if(def instanceof Infantry) {
																type2="Infantry";
																soldier2.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2.setVisible(true);
																buttondef=new JButton();
																buttondef.setBounds(1000, 400, 300, 350);
																buttondef.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttondef.setVisible(true);
																FB.add(buttondef);
															}
															if(def instanceof Cavalry) {
																type2="Cavalry";
																soldier2.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2.setVisible(true);
																buttondef=new JButton();
																buttondef.setBounds(1000, 400, 300, 350);
																buttondef.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttondef.setVisible(true);
																FB.add(buttondef);
															}
														}
														
														if(e.getSource()==startbattler) {
															mbutton.setVisible(false);
															soldier1r.setVisible(false);
															soldier2r.setVisible(false);
															attackercr.setVisible(true);	
															String type1="";
															String type2="";
															int q=attackuc.getSelectedIndex();
															int r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1;
															if(q==9)
																r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-7)))-1;
															buttonattr.setVisible(false);
															buttondefr.setVisible(false);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-1)))-1);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1);
															att=game.getPlayer().getControlledArmies().get(r).getUnits().get(q);
															for(City city : game.getAvailableCities()) {
																if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																	def=city.getDefendingArmy().getUnits().get(defenduc.getSelectedIndex());
																}
															}
															if(att instanceof Archer) {
																type1="Archer";
																soldier1r.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1r.setVisible(true);
																buttonattr=new JButton();
																buttonattr.setBounds(200, 400, 300, 350);
																buttonattr.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttonattr.setVisible(true);
																FBR.add(buttonattr);
															}
															if(att instanceof Infantry) {
																type1="Infantry";
																soldier1r.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1r.setVisible(true);
																buttonattr=new JButton();
																buttonattr.setBounds(200, 400, 300, 350);
																buttonattr.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttonattr.setVisible(true);
																FBR.add(buttonattr);
															}
															if(att instanceof Cavalry) {
																type1="Cavalry";
																soldier1r.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1r.setVisible(true);
																buttonattr=new JButton();
																buttonattr.setBounds(200, 400, 300, 350);
																buttonattr.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttonattr.setVisible(true);
																FBR.add(buttonattr);
															}
															if(def instanceof Archer) {
																type2="Archer";
																soldier2r.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2r.setVisible(true);
																buttondefr=new JButton();
																buttondefr.setBounds(1000, 400, 300, 350);
																buttondefr.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttondefr.setVisible(true);
																FBR.add(buttondefr);
															}
															if(def instanceof Infantry) {
																type2="Infantry";
																soldier2r.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2r.setVisible(true);
																buttondefr=new JButton();
																buttondefr.setBounds(1000, 400, 300, 350);
																buttondefr.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttondefr.setVisible(true);
																FBR.add(buttondefr);
															}
															if(def instanceof Cavalry) {
																type2="Cavalry";
																soldier2r.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2r.setVisible(true);
																buttondefr=new JButton();
																buttondefr.setBounds(1000, 400, 300, 350);
																buttondefr.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttondefr.setVisible(true);
																FBR.add(buttondefr);
															}
														}
														
														if(e.getSource()==startbattles) {
															mbutton.setVisible(false);
															soldier1s.setVisible(false);
															soldier2s.setVisible(false);
															attackercs.setVisible(true);	
															String type1="";
															String type2="";
															int q=attackuc.getSelectedIndex();
															int r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1;
															if(q==9)
																r=Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-7)))-1;
															buttonatts.setVisible(false);
															buttondefs.setVisible(false);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-1)))-1);
															//System.out.println(Integer.parseInt(String.valueOf(attacku[attackuc.getSelectedIndex()].charAt(attacku[attackuc.getSelectedIndex()].length()-6)))-1);
															att=game.getPlayer().getControlledArmies().get(r).getUnits().get(q);
															for(City city : game.getAvailableCities()) {
																if(city.getName().equalsIgnoreCase(lcairo.getText())) {
																	def=city.getDefendingArmy().getUnits().get(defenduc.getSelectedIndex());
																}
															}
															if(att instanceof Archer) {
																type1="Archer";
																soldier1s.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1s.setVisible(true);
																buttonatts=new JButton();
																buttonatts.setBounds(200, 400, 300, 350);
																buttonatts.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttonatts.setVisible(true);
																FBS.add(buttonatts);
															}
															if(att instanceof Infantry) {
																type1="Infantry";
																soldier1s.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1s.setVisible(true);
																buttonatts=new JButton();
																buttonatts.setBounds(200, 400, 300, 350);
																buttonatts.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttonatts.setVisible(true);
																FBS.add(buttonatts);
															}
															if(att instanceof Cavalry) {
																type1="Cavalry";
																soldier1s.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1s.setVisible(true);
																buttonatts=new JButton();
																buttonatts.setBounds(200, 400, 300, 350);
																buttonatts.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttonatts.setVisible(true);
																FBS.add(buttonatts);
															}
															if(def instanceof Archer) {
																type2="Archer";
																soldier2s.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2s.setVisible(true);
																buttondefs=new JButton();
																buttondefs.setBounds(1000, 400, 300, 350);
																buttondefs.setIcon(new ImageIcon(this.getClass().getResource("/archer1.png").getFile()));
																buttondefs.setVisible(true);
																FBS.add(buttondefs);
															}
															if(def instanceof Infantry) {
																type2="Infantry";
																soldier2s.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2s.setVisible(true);
																buttondefs=new JButton();
																buttondefs.setBounds(1000, 400, 300, 350);
																buttondefs.setIcon(new ImageIcon(this.getClass().getResource("/infantry1.png").getFile()));
																buttondefs.setVisible(true);
																FBS.add(buttondefs);
															}
															if(def instanceof Cavalry) {
																type2="Cavalry";
																soldier2s.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2s.setVisible(true);
																buttondefs=new JButton();
																buttondefs.setBounds(1000, 400, 300, 350);
																buttondefs.setIcon(new ImageIcon(this.getClass().getResource("/cavalry1.png").getFile()));
																buttondefs.setVisible(true);
																FBS.add(buttondefs);
															}
														}
														
														else {
															if(e.getSource()==attackerc) {
																//soldier1.setVisible(false);
																soldier2.setVisible(false);
																soldier1.setVisible(false);
																try {
																	att.attack(def);
																	def.attack(att);
																} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(FB, "You cannot attack friendly unit","!!!",JOptionPane.WARNING_MESSAGE);
																	e1.printStackTrace();
																}
																if(att instanceof Archer)
																	type1="Archer";
																if(att instanceof Infantry)
																	type1="Infantry";
																if(att instanceof Cavalry)
																	type1="Cavalry";
																if(def instanceof Archer)
																	type2="Archer";
																if(def instanceof Infantry)
																	type2="Infantry";
																if(def instanceof Cavalry)
																	type2="Cavalry";
																soldier2.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2.setVisible(true);
																soldier1.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1.setVisible(true);
																if(def.getCurrentSoldierCount()==0) {
																	buttondef.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	lll.setBounds(1120, 500, 300, 50);
																	llll.setBounds(1095, 550, 300, 50);
																	FB.add(lll);
																	FB.add(llll);
																	FB.add(mbutton);
																	attackc.doClick();
															
																}
																if(att.getCurrentSoldierCount()==0) {
																	buttonatt.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	llle.setBounds(320, 500, 300, 50);
																	lllle.setBounds(295, 550, 300, 50);
																	FB.add(llle);
																	FB.add(lllle);
																	FB.add(mbutton);
																	flagoo1=true;
																	attackc.doClick();
															
																}
																if(defenduc.getSelectedItem()==null) {
																	game.occupy(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()) , lcairo.getText());
																	FB.dispose();
																	FT.setVisible(true);
																}
																if(attackuc.getSelectedItem()==null) {
																	FB.dispose(); 
																	cong.setText("              You Lost The Battle");
																	FT.setVisible(true); 
																}
															}
															
															if(e.getSource()==attackercr) {
																//soldier1.setVisible(false);
																soldier2r.setVisible(false);
																soldier1r.setVisible(false);
																try {
																	att.attack(def);
																	def.attack(att);
																} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(FBR, "You cannot attack friendly unit","!!!",JOptionPane.WARNING_MESSAGE);
																	e1.printStackTrace();
																}
																if(att instanceof Archer)
																	type1="Archer";
																if(att instanceof Infantry)
																	type1="Infantry";
																if(att instanceof Cavalry)
																	type1="Cavalry";
																if(def instanceof Archer)
																	type2="Archer";
																if(def instanceof Infantry)
																	type2="Infantry";
																if(def instanceof Cavalry)
																	type2="Cavalry";
																soldier2r.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2r.setVisible(true);
																soldier1r.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1r.setVisible(true);
																if(def.getCurrentSoldierCount()==0) {
																	buttondefr.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	lll.setBounds(1120, 500, 300, 50);
																	llll.setBounds(1095, 550, 300, 50);
																	FBR.add(lll);
																	FBR.add(llll);
																	FBR.add(mbutton);
																	attackr.doClick();
															
																}
																if(att.getCurrentSoldierCount()==0) {
																	buttonattr.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	llle.setBounds(320, 500, 300, 50);
																	lllle.setBounds(295, 550, 300, 50);
																	FBR.add(llle);
																	FBR.add(lllle);
																	FBR.add(mbutton);
																	flagoo2=true;
																	attackr.doClick();
															
																}
																if(defenduc.getSelectedItem()==null) {
																	game.occupy(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()) , lcairo.getText());
																	FBR.dispose();
																	FTR.setVisible(true);
																}
																if(attackuc.getSelectedItem()==null) {
																	FBR.dispose();
																	congr.setText("              You Lost The Battle");
																	FTR.setVisible(true);
																}
															}
															
															
															if(e.getSource()==attackercs) {
																//soldier1.setVisible(false);
																soldier2s.setVisible(false);
																soldier1s.setVisible(false);
																try {
																	att.attack(def);
																	def.attack(att);
																} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(FBS, "You cannot attack friendly unit","!!!",JOptionPane.WARNING_MESSAGE);
																	e1.printStackTrace();
																}
																if(att instanceof Archer)
																	type1="Archer";
																if(att instanceof Infantry)
																	type1="Infantry";
																if(att instanceof Cavalry)
																	type1="Cavalry";
																if(def instanceof Archer)
																	type2="Archer";
																if(def instanceof Infantry)
																	type2="Infantry";
																if(def instanceof Cavalry)
																	type2="Cavalry";
																soldier2s.setText(type2+" level "+def.getLevel()+" CurrenSoldiersCount : "+def.getCurrentSoldierCount()+"/"+def.getMaxSoldierCount());
																soldier2s.setVisible(true);
																soldier1s.setText(type1+" level "+att.getLevel()+" CurrenSoldiersCount : "+att.getCurrentSoldierCount()+"/"+att.getMaxSoldierCount());
																soldier1s.setVisible(true);
																if(def.getCurrentSoldierCount()==0) {
																	buttondefs.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	lll.setBounds(1120, 500, 300, 50);
																	llll.setBounds(1095, 550, 300, 50);
																	FBS.add(lll);
																	FBS.add(llll);
																	FBS.add(mbutton);
																	attacks.doClick();
															
																}
																if(att.getCurrentSoldierCount()==0) {
																	buttonatts.setVisible(false);
																	mbutton =new JButton("Unit is dead");
																	mbutton.setBounds(1000, 400, 300, 350);
																	llle.setBounds(320, 500, 300, 50);
																	lllle.setBounds(295, 550, 300, 50);
																	FBS.add(llle);
																	FBS.add(lllle);
																	FBS.add(mbutton);
																	flagoo3=true;
																	attacks.doClick();
															
																}
																if(defenduc.getSelectedItem()==null) {
																	game.occupy(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()) , lcairo.getText());
																	FBS.dispose();
																	FTS.setVisible(true);
																}
																if(attackuc.getSelectedItem()==null) {
																	FBS.dispose();
																	congs.setText("              You Lose The Battle");
																	FTS.setVisible(true);
																}
															}
															
															else {
																if(e.getSource()==backtocity) {
																	FT.dispose();
																	map.doClick();
																}
																if(e.getSource()==backtocityr) {
																	FTR.dispose();
																	mapr.doClick();
																}
																if(e.getSource()==backtocitys) {
																	FTS.dispose();
																	maps.doClick();
																}
																else {
																	if(e.getSource()==targetc) {
																		if(coarmiesa.getSelectedItem()!=null)
																			game.targetCity(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),"Cairo");
																		else
																			JOptionPane.showMessageDialog(F2,"You must initiate army first");
																		//System.out.println(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getDistancetoTarget());
																	}
																	if(e.getSource()==targetr) {
																		if(coarmiesa.getSelectedItem()!=null)
																			game.targetCity(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),"Rome");
																		else
																			JOptionPane.showMessageDialog(F2,"You must initiate army first");
																		//System.out.println(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getDistancetoTarget());
																	}
																	if(e.getSource()==targets) {
																		if(coarmiesa.getSelectedItem()!=null)
																			game.targetCity(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),"Sparta");
																		else
																			JOptionPane.showMessageDialog(F2,"You must initiate army first");
																		//System.out.println(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getDistancetoTarget());
																	}
																	else {
																		if(e.getSource()==seigec) {
																			if(game.getPlayer().getControlledArmies().size()>0 && game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0) {
																			for(City city : game.getAvailableCities()) {
																				if(city.getName().equalsIgnoreCase("Cairo")) {
																					try {
																						game.getPlayer().laySiege(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city);
																						useigec.setText("Cairo is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
																						useigec.setVisible(true);
																					} catch (TargetNotReachedException e1) {JOptionPane.showMessageDialog(F2,"Target Not Reached","!!!" ,JOptionPane.WARNING_MESSAGE);
																						e1.printStackTrace();
																					} catch (FriendlyCityException e1) {JOptionPane.showMessageDialog(F2,"You can't attack a friendly city","!!!" ,JOptionPane.WARNING_MESSAGE);
																					e1.printStackTrace();
																				}
																					
																				}
																			}
																		}
																			else {
																				JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
																			}
																	}
																		if(e.getSource()==seiger) {
																			if(game.getPlayer().getControlledArmies().size()>0 && game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0) {
																			for(City city : game.getAvailableCities()) {
																				if(city.getName().equalsIgnoreCase("Rome")) {
																					try {
																						game.getPlayer().laySiege(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city);
																						useiger.setText("Rome is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
																						useiger.setVisible(true);
																					} catch (TargetNotReachedException e1) {JOptionPane.showMessageDialog(F2,"Target Not Reached","!!!" ,JOptionPane.WARNING_MESSAGE);
																						e1.printStackTrace();
																					} catch (FriendlyCityException e1) {JOptionPane.showMessageDialog(F2,"You can't attack a friendly city","!!!" ,JOptionPane.WARNING_MESSAGE);
																					e1.printStackTrace();
																				}
																					
																				}
																			}
																		}
																			else {
																				JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
																			}
																		}
																		if(e.getSource()==seiges) {
																			if(game.getPlayer().getControlledArmies().size()>0 && game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0) {
																			for(City city : game.getAvailableCities()) {
																				if(city.getName().equalsIgnoreCase("Sparta")) {
																					try {
																						game.getPlayer().laySiege(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city);
																						useiges.setText("Sparta is underseige   TurnsUnderSiege "+city.getTurnsUnderSiege());
																						useiges.setVisible(true);
																					} catch (TargetNotReachedException e1) {JOptionPane.showMessageDialog(F2,"Target Not Reached","!!!" ,JOptionPane.WARNING_MESSAGE);
																						e1.printStackTrace();
																					} catch (FriendlyCityException e1) {JOptionPane.showMessageDialog(F2,"You can't attack a friendly city","!!!" ,JOptionPane.WARNING_MESSAGE);
																					e1.printStackTrace();
																				}
																					
																				}
																			}
																		}
																			else {
																				JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
																			}
																		}
																		else {
																			if(e.getSource()==attackfc) {
																				FFC.dispose();
																				attackc.doClick();
																			}
																			if(e.getSource()==attackfr) {
																				FFR.dispose();
																				attackr.doClick();
																			}
																			if(e.getSource()==attackfs) {
																				FFS.dispose();
																				attacks.doClick();
																			}
																			else {
																				if(e.getSource()==autoc) {
																					if(game.getPlayer().getControlledArmies().size()>0 && game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0 ) {
																					for(City city : game.getPlayer().getControlledCities()) {
																						if(city.getName().equalsIgnoreCase("Cairo"))
																							fc=true;
																					}
																					if(fc==false) {
																					if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("Cairo")) {
																					for(City city : game.getAvailableCities()) {
																						if(city.getName().equalsIgnoreCase("Cairo")) {
																							try {
																								game.autoResolve(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city.getDefendingArmy());
																								for(City cityy : game.getPlayer().getControlledCities()) {
																									if(cityy.getName().equalsIgnoreCase("Cairo")) {
																										F2.dispose();
																										cong.setText("Congratulations!!! You Won The Battle");
																										FT.setVisible(true);
																									}
																									else {
																										F2.dispose();
																										cong.setText("              You Lost The Battle");
																										FT.setVisible(true);
																									}
																										
																								}
																							} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(F2,"Cannot attack a friendly unit","!!!" ,JOptionPane.WARNING_MESSAGE);
																							e1.printStackTrace();
																							}
																						}
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"Target Not Reached");
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"You Cannot attack a friendly city");
																					}
																				
																				}
																				else {
																					JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
																				}
																		}
																				if(e.getSource()==autor) {
																					if(game.getPlayer().getControlledArmies().size()>0 && game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getUnits().size()>0) {
																					for(City city : game.getPlayer().getControlledCities()) {
																						if(city.getName().equalsIgnoreCase("Rome"))
																							fr=true;
																					}
																					if(fr==false) {
																					if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("Rome")) {
																					for(City city : game.getAvailableCities()) {
																						if(city.getName().equalsIgnoreCase("Rome")) {
																							try {
																								game.autoResolve(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city.getDefendingArmy());
																								for(City cityy : game.getPlayer().getControlledCities()) {
																									if(cityy.getName().equalsIgnoreCase("Rome")) {
																										F2.dispose();
																										congr.setText("Congratulations!!! You Won The Battle");
																										FTR.setVisible(true);
																									}
																									else {
																										F2.dispose();
																										congr.setText("              You Lost The Battle");
																										FTR.setVisible(true);
																									}
																										
																								}
																							} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(F2,"Cannot attack a friendly unit","!!!" ,JOptionPane.WARNING_MESSAGE);
																							e1.printStackTrace();
																							}
																						}
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"Target Not Reached");
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"You Cannot attack a friendly city");
																					}
																				
																				}
																				else {
																					JOptionPane.showMessageDialog(F2,"You must initiate army first within units");
																				}
																		}
																				if(e.getSource()==autos) {
																					if(game.getPlayer().getControlledArmies().size()>0) {
																					for(City city : game.getPlayer().getControlledCities()) {
																						if(city.getName().equalsIgnoreCase("Sparta"))
																							fs=true;
																					}
																					if(fs==false) {
																					if(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()).getCurrentLocation().equalsIgnoreCase("Sparta")) {
																					for(City city : game.getAvailableCities()) {
																						if(city.getName().equalsIgnoreCase("Sparta")) {
																							try {
																								game.autoResolve(game.getPlayer().getControlledArmies().get(coarmiesa.getSelectedIndex()),city.getDefendingArmy());
																								for(City cityy : game.getPlayer().getControlledCities()) {
																									if(cityy.getName().equalsIgnoreCase("Sparta")) {
																										F2.dispose();
																										congs.setText("Congratulations!!! You Won The Battle");
																										FTS.setVisible(true);
																									}
																									else {
																										F2.dispose();
																										congs.setText("              You Lost The Battle");
																										FTS.setVisible(true);
																									}
																										
																								}
																							} catch (FriendlyFireException e1) {JOptionPane.showMessageDialog(F2,"Cannot attack a friendly unit","!!!" ,JOptionPane.WARNING_MESSAGE);
																							e1.printStackTrace();
																							}
																						}
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"Target Not Reached");
																					}
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"You Cannot attack a friendly city");
																					}
																				
																				}
																					else {
																						JOptionPane.showMessageDialog(F2,"You must initiate army first");
																					}
																			}
																				else {
																					if(e.getSource()==autofc) {
																						FFC.dispose();
																						autoc.doClick();
																					}
																					if(e.getSource()==autofr) {
																						FFR.dispose();
																						autor.doClick();
																					}
																					if(e.getSource()==autofs) {
																						FFS.dispose();
																						autos.doClick();
																					}
																					else {
																						if(e.getSource()==backmenuc) {
																							FOC.dispose();
																							new First();
																						}
																						if(e.getSource()==backmenur) {
																							FOR.dispose();
																							new First();
																						}
																						if(e.getSource()==backmenus) {
																							FOS.dispose();
																							new First();
																						}
																						else {
																							if(e.getSource()==showw) {
																
																								int tetoti=0;
																								int fasel=0;
																								if(Armies.getSelectedIndex()==0) {
																									FBES = new JFrame();
																									FBES.setSize(1500, 750);
																									FBES.getContentPane().setLayout(null);
																									FBES.setVisible(false);
																									FBES.setResizable(false);
																									FBES.add(bbes);
																									int xa=0;
																									int ya=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										tetoti++;
																										if(army.getCurrentStatus()==Status.BESIEGING) {
																											JLabel tetot=new JLabel("Army "+tetoti);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FBES.add(tetot);
																											fasel+=100;
																											
															
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FBES.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FBES.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FBES.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																											}
																											xa=0;
																											ya+=100;
																										}
																									}
																									F2.dispose();
																									FBES.setVisible(true);
																								}
																								if(Armies.getSelectedIndex()==1) {
																									FMAR = new JFrame();
																									FMAR.setSize(1500, 750);
																									FMAR.getContentPane().setLayout(null);
																									FMAR.setVisible(false);
																									FMAR.setResizable(false);
																									FMAR.add(bmar);
																									int xa=0;
																									int ya=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										tetoti++;
																										if(army.getCurrentStatus()==Status.MARCHING) {
																											JLabel tetot=new JLabel("Army "+tetoti);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FMAR.add(tetot);
																											fasel+=100;
																											
																										
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FMAR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FMAR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FMAR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																											}
																											xa=0;
																											ya+=100;
																										}
																									}
																									F2.dispose();
																									FMAR.setVisible(true);
																								}
																								if(Armies.getSelectedIndex()==2) {
																									FIDL = new JFrame();
																									FIDL.setSize(1500, 750);
																									FIDL.getContentPane().setLayout(null);
																									FIDL.setVisible(false);
																									FIDL.setResizable(false);
																									FIDL.add(bidl);
																									int xa=0;
																									int ya=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										tetoti++;
																										if(army.getCurrentStatus()==Status.IDLE) {
																											JLabel tetot=new JLabel("Army "+tetoti);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FIDL.add(tetot);
																											fasel+=100;
																											
																										
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FIDL.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FIDL.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FIDL.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																											}
																											xa=0;
																											ya+=100;
																										}
																									}
																									F2.dispose();
																									FIDL.setVisible(true);
																								}
																								
																							}
																							else {
																								if(e.getSource()==viewarmycc) {
																									FCC = new JFrame();
																									FCC.setSize(1500,750);
																									FCC.getContentPane().setLayout(null);
																									FCC.setVisible(false);
																									FCC.setResizable(false);
																									FCC.add(bcc);
																									int xa=0;
																									int ya=0;
																									int j=0;
																									int fasel=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										j++;
																										
																										if(army.getCurrentLocation().equalsIgnoreCase("Cairo")) {
																											JLabel tetot=new JLabel("Army "+j);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FCC.add(tetot);
																											fasel+=100;
																											
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FCC.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCC.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCC.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																										}
																											xa=0;
																											ya+=100;
																									}
																								}
																									FC.dispose();
																									FCC.setVisible(true);
																							}
																								if(e.getSource()==viewarmycr) {
																									FCR = new JFrame();
																									FCR.setSize(1500,750);
																									FCR.getContentPane().setLayout(null);
																									FCR.setVisible(false);
																									FCR.setResizable(false);
																									FCR.add(bcr);
																									int xa=0;
																									int ya=0;
																									int j=0;
																									int fasel=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										j++;
																										
																										if(army.getCurrentLocation().equalsIgnoreCase("Rome")) {
																											JLabel tetot=new JLabel("Army "+j);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FCR.add(tetot);
																											fasel+=100;
																											
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FCR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCR.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																										}
																											xa=0;
																											ya+=100;
																									}
																								}
																									FR.dispose();
																									FCR.setVisible(true);
																							}
																								if(e.getSource()==viewarmycs) {
																									FCS = new JFrame();
																									FCS.setSize(1500,750);
																									FCS.getContentPane().setLayout(null);
																									FCS.setVisible(false);
																									FCS.setResizable(false);
																									FCS.add(bcs);
																									int xa=0;
																									int ya=0;
																									int j=0;
																									int fasel=0;
																									for(Army army : game.getPlayer().getControlledArmies()) {
																										j++;
																										
																										if(army.getCurrentLocation().equalsIgnoreCase("Sparta")) {
																											JLabel tetot=new JLabel("Army "+j);
																											tetot.setBounds(300, 0+fasel, 300, 30);
																											FCS.add(tetot);
																											fasel+=100;
																											
																											for(Unit unit : army.getUnits()) {
																												if(unit instanceof Archer) {
																													JLabel teto=new JLabel("Archer level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 40+ya, 300, 30);
																													FCS.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Infantry) {
																													JLabel teto=new JLabel("Infantry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCS.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																												if(unit instanceof Cavalry) {
																													JLabel teto=new JLabel("Cavalry level "+unit.getLevel()+" CurrentSoldierCount "+unit.getCurrentSoldierCount()+"/"+unit.getMaxSoldierCount());
																													teto.setBounds(0+xa, 50+ya, 300, 30);
																													FCS.add(teto);
																													xa+=300;
																													if(xa==1500) {
																														xa=0;
																														ya+=30;
																													}
																												}
																										}
																											xa=0;
																											ya+=100;
																									}
																								}
																									FS.dispose();
																									FCS.setVisible(true);
																									
																							}
																								else {
																									if(e.getSource()==bcc) {
																										FCC.dispose();
																										FC.setVisible(true);
																									}
																									if(e.getSource()==bcr) {
																										FCR.dispose();
																										FR.setVisible(true);
																									}
																									if(e.getSource()==bcs) {
																										FCS.dispose();
																										FS.setVisible(true);
																									}
																									else {
																										if(e.getSource()==bbes) {
																											FBES.dispose();
																											F2.setVisible(true);
																										}
																										if(e.getSource()==bmar) {
																											FMAR.dispose();
																											F2.setVisible(true);
																										}
																										if(e.getSource()==bidl) {
																											FIDL.dispose();
																											F2.setVisible(true);
																										}
																									}
																								}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
						}
					}
				}
			}
		}
		}
		}
	}

	public static void main(String[] args) {
		First m = new First();
		//String s = "c1";
		// JComboBox s=new JComboBox;

		// System.out.println(unitss[cityUnitss.getSelectedIndex()].charAt(unitss[cityUnitss.getSelectedIndex()].length()-6));

	}
}

