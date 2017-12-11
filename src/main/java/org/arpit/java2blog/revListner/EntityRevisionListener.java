package org.arpit.java2blog.revListner;


import org.hibernate.envers.RevisionListener;

/**
 * Created by mndeveci on 21.11.2016.
 */
public class EntityRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        System.out.println("New revision is created: " + o);
    }
}
