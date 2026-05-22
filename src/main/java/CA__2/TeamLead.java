/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author driss
 */
public class TeamLead extends Manager {
    String teamName;

    public TeamLead(String fn, String ln, String dept, String title, String comp) {
        super(fn, ln, dept, title, comp);
        this.teamName = "";
    }

    public String getTeamName() { return teamName; }
}
