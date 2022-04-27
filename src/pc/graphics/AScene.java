package pc.graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AScene implements Scene {
	
	Avatar ChefA;
	Avatar ChefB;
	Avatar ChefC;
	Avatar ChefD;
	Avatar PatronA;
	Avatar PatronB;
	Avatar PatronC;
	Avatar PatronD;
	
	Table TableA;
	Table TableB;
	Table TableC;
	Table TableD;
	
	int Chef_X = 50;
	int AvatarA_Y = 50;
	int AvatarB_Y = 200;
	int AvatarC_Y = 320;
	int AvatarD_Y = 450;
	
	int Patron_X = 600;
	
	int Table_X = 615;
	int TableOffset_Y = 35;
	
	public AScene() {
		ChefA = new AnAvatar();
		ChefB = new AnAvatar();
		ChefC = new AnAvatar();
		ChefD = new AnAvatar();
		PatronA = new AnAvatar();
		PatronB = new AnAvatar();
		PatronC = new AnAvatar();
		PatronD = new AnAvatar();
		
		TableA = new ATable();
		TableB = new ATable();
		TableC = new ATable();
		TableD = new ATable();
		
		TableA.move(Table_X, AvatarA_Y+TableOffset_Y);
		TableB.move(Table_X, AvatarB_Y+TableOffset_Y);
		TableC.move(Table_X, AvatarC_Y+TableOffset_Y);
		TableD.move(Table_X, AvatarD_Y+TableOffset_Y);
		
		ChefA.move(Chef_X, AvatarA_Y);
		ChefB.move(Chef_X, AvatarB_Y);
		ChefC.move(Chef_X, AvatarC_Y);
		ChefD.move(Chef_X, AvatarD_Y);
		
		PatronA.move(Patron_X, AvatarA_Y);
		PatronB.move(Patron_X, AvatarB_Y);
		PatronC.move(Patron_X, AvatarC_Y);
		PatronD.move(Patron_X, AvatarD_Y);
		
		
	}

	@Override
	public Avatar getChefA() {
		return ChefA;
	}

	@Override
	public Avatar getChefB() {
		return ChefB;
	}

	@Override
	public Avatar getChefC() {
		return ChefC;
	}

	@Override
	public Avatar getChefD() {
		return ChefD;
	}

	@Override
	public Avatar getPatronA() {
		return PatronA;
	}

	@Override
	public Avatar getPatronB() {
		return PatronB;
	}

	@Override
	public Avatar getPatronC() {
		return PatronC;
	}

	@Override
	public Avatar getPatronD() {
		return PatronD;
	}

	@Override
	public Table getTableA() {
		return TableA;
	}

	@Override
	public Table getTableB() {
		return TableB;
	}

	@Override
	public Table getTableC() {
		return TableC;
	}

	@Override
	public Table getTableD() {
		return TableD;
	}

}
