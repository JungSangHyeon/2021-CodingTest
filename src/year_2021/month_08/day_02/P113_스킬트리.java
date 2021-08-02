package year_2021.month_08.day_02;

public class P113_스킬트리 {

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
	}

	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees) {
        	String testSkillTree = "";
        	for(int i=0; i<skillTree.length(); i++) {
        		String learnSkill = String.valueOf(skillTree.charAt(i));
        		if(skill.contains(learnSkill)) testSkillTree += learnSkill;
        	}
        	String correctSkillTree = skill.substring(0, testSkillTree.length());
        	if(testSkillTree.equals(correctSkillTree)) answer++;
        }
        return answer;
    }
}
