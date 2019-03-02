package agents.vehicles.messages.templates;

import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import utils.configuration.Config;;

/**
 * The class responsible for the CFP/Alarm Detected Fire ACL Message Template
 */
public class AlarmDetectedFireACLMessageTemplate extends MessageTemplate {
	
	// Constants/Invariants:

	/**
	 * The default UID of the CFP/Alarm Detected Fire ACL Message Template.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The CFP/Alarm Detected Fire ACL Message Template, with all defined parameters/settings.
	 */
	private static MessageTemplate alarmDetectedFireACLMessageTemplate = AlarmDetectedFireACLMessageTemplate.
			and(
					AlarmDetectedFireACLMessageTemplate.and(
						AlarmDetectedFireACLMessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET),
						AlarmDetectedFireACLMessageTemplate.MatchPerformative(ACLMessage.CFP)
					),
					AlarmDetectedFireACLMessageTemplate.MatchOntology(Config.DETECTED_FIRE_ALARM_ONTOLOGY)
				);
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the CFP/Alarm Detected Fire ACL Message Template.
	 * 
	 * @param initialAlarmDetectedFireACLMessageTemplate an initial CFP/Alarm Detected Fire ACL Message Template
	 */
	public AlarmDetectedFireACLMessageTemplate() {
		super((MatchExpression) alarmDetectedFireACLMessageTemplate);
	}

	/**
	 * Returns the CFP/Alarm Detected Fire ACL Message Template.
	 * 
	 * @return the CFP/Alarm Detected Fire ACL Message Template
	 */
	public MessageTemplate getAlarmDetectedFireACLMessageTemplate() {
		return AlarmDetectedFireACLMessageTemplate.alarmDetectedFireACLMessageTemplate;
	}
}