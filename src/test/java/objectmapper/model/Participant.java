package objectmapper.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Participant
{

    public enum PARTICIPANT_STATUS
    {
        ACTIVE, INACTIVE
    }

    private static final long serialVersionUID = 2465765206495620587L;

    private List<ParticipantCapability> capabilities;

    private String channelType;

    private UUID id;

    private String referenceId;

    private String referenceType;

    private List<String> skills;

    private Instant expiration;

    private String status;

    public Participant()
    {
    }

    public Participant( List<ParticipantCapability> capabilities, String channelType, UUID id,
            String referenceId, String referenceType, List<String> skills, Instant expiration, String status )
    {
        this.capabilities = capabilities;
        this.channelType = channelType;
        this.id = id;
        this.referenceId = referenceId;
        this.referenceType = referenceType;
        this.skills = skills;
        this.expiration = expiration;
        this.status = status;
    }

    public List<ParticipantCapability> getCapabilities()
    {
        return capabilities;
    }

    public void setCapabilities( List<ParticipantCapability> capabilities )
    {
        this.capabilities = capabilities;
    }

    public String getChannelType()
    {
        return channelType;
    }

    public void setChannelType( String channelType )
    {
        this.channelType = channelType;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId( UUID id )
    {
        this.id = id;
    }

    public String getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId( String referenceId )
    {
        this.referenceId = referenceId;
    }

    public String getReferenceType()
    {
        return referenceType;
    }

    public void setReferenceType( String referenceType )
    {
        this.referenceType = referenceType;
    }

    public List<String> getSkills()
    {
        return skills;
    }

    public void setSkills( List<String> skills )
    {
        this.skills = skills;
    }

    public Instant getExpiration()
    {
        return expiration;
    }

    public void setExpiration( Instant expiration )
    {
        this.expiration = expiration;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }
}
