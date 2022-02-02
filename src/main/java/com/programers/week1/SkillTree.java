package com.programers.week1;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";                                           // 스킬트리
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BCDA"};       // 스킬목록

        System.out.println(new SkillTree().solution(skill, skill_trees));
    }

    // 의미없는 글자를 모두 없앤 문자열(filteredSkill) 을 만들고 나면 skill.startsWith(filteredSkill) 만으로도 조건에 만족하는지 확인

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String sTree : skill_trees) {
            String temp = chkSkill(skill, sTree);
            System.out.println(skill + "====" + temp + "====" +skill.startsWith(temp)) ;
            if(skill.startsWith(temp)) {
                answer++;
            }
        }

        return answer;
    }

    private String chkSkill(String skill, String sTree) {
        StringBuilder sb = new StringBuilder();
        String[] skills = sTree.split("");

        for (String s: skills) {
            if(skill.contains(s)) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

}
