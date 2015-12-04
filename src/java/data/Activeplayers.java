/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "activeplayers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activeplayers.findAll", query = "SELECT a FROM Activeplayers a"),
    @NamedQuery(name = "Activeplayers.findByUid", query = "SELECT a FROM Activeplayers a WHERE a.uid = :uid"),
    @NamedQuery(name = "Activeplayers.findByGame", query = "SELECT a FROM Activeplayers a WHERE a.game = :game"),
    @NamedQuery(name = "Activeplayers.findByInGameWith", query = "SELECT a FROM Activeplayers a WHERE a.inGameWith = :inGameWith")})
public class Activeplayers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "uid")
    private String uid;
    @Column(name = "game#")
    private Integer game;
    @Size(max = 25)
    @Column(name = "inGameWith")
    private String inGameWith;
    @Lob
    @Column(name = "player")
    private byte[] player;
    @JoinColumn(name = "uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public Activeplayers() {
    }

    public Activeplayers(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public String getInGameWith() {
        return inGameWith;
    }

    public void setInGameWith(String inGameWith) {
        this.inGameWith = inGameWith;
    }

    public byte[] getPlayer() {
        return player;
    }

    public void setPlayer(byte[] player) {
        this.player = player;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activeplayers)) {
            return false;
        }
        Activeplayers other = (Activeplayers) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Activeplayers[ uid=" + uid + " ]";
    }
    
}