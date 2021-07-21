package model;

public class Search {

	private Search() {

	}

	public static Search instance = new Search();

	public static Search getInstance() {
		return instance;
	}

	public boolean isMatch(String s, String p) {
		if (s.isEmpty()) {
			return true;
		} else {
			int j1 = 1;
			for (int i1 = 0; i1 < s.length(); i1++) {
				int j2 = 0;
				for (int i2 = 0; i2 < p.length(); i2++) {
					if (s.charAt(i1) == p.charAt(i2)) {
						j2 = 1;
					}
				}
				j1 *= j2;
			}
			if (j1 == 1) {
				return true;
			} else {
				return false;
			}
		}

	}

}
