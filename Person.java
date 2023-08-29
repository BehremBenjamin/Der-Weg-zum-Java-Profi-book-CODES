package org.example;

import java.util.Collections;
import java.util.List;

public interface IPersonRO {
    void getName();
}

class Person implements IPersonRO {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        return this.name;
    }
}

public interface IClubMembersRO extends IPersonRO {

    List<IPersonRO> getAllMembers();
    IPersonRO getMemberByName();
}

class ClubMembers implements IClubMembersRO {

    List<Person> members;
    Person person;

    @Override
    public List<IPersonRO> getAllMembers() {
        return (List<IPersonRO>) Collections.unmodifiableList(members);
    }

    @Override
    public IPersonRO getMemberByName( final String name) throws Exception {
        for (IPersonRO pRO : members) {
            if (name.equals(pRO.getName())) {
                return pRO;
            }
            else  {
                System.out.println("member not found");
            }
        }
        return null;
    }
}
