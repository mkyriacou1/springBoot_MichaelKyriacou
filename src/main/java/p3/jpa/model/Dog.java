package p3.jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Table(name="dogs")
public class Dog {

	@Id
	@GeneratedValue	
		 private Long id;
		 private String name;
		 private String type;

		public  Dog(String name, String type) {
			super();
			this.name = name;
			this.type = type;
		
		}
}

