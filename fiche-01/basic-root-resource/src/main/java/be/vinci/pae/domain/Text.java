package be.vinci.pae.domain;

import java.util.Arrays;

public class Text {
	private int id;
	private String content;
	private final static String[] POSSIBLE_LEVELS = { "easy", "medium", "hard" };
	private String level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = Arrays.stream(POSSIBLE_LEVELS).filter(possibleLevel -> possibleLevel.equals(level)).findFirst()
				.orElse(null);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text [id=" + id + ", content=" + content + ", level=" + level + "]";
	}

}
