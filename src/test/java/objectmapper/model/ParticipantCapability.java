package objectmapper.model;

import java.util.HashMap;
import java.util.Map;

public class ParticipantCapability
{
    private String type;

    private Map<String, String> details = new HashMap<>();

    public ParticipantCapability()
    {
    }

    public ParticipantCapability( String type, Map<String, String> details )
    {
        this.type = type;
        this.details = details;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public Map<String, String> getDetails()
    {
        return details;
    }

    public void setDetails( Map<String, String> details )
    {
        this.details = details;
    }
}
