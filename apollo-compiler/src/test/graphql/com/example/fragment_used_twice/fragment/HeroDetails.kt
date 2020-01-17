// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class HeroDetails(
  val __typename: String,
  /**
   * The name of the character
   */
  val name: String,
  val fragments: Fragments
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
    it.writeString(RESPONSE_FIELDS[0], __typename)
    it.writeString(RESPONSE_FIELDS[1], name)
    fragments.marshaller().marshal(it)
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null)
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment HeroDetails on Character {
        |  __typename
        |  name
        |  ...CharacterDetails
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HeroDetails {
      val __typename = reader.readString(RESPONSE_FIELDS[0])
      val name = reader.readString(RESPONSE_FIELDS[1])
      val fragments = Fragments(reader)
      return HeroDetails(
        __typename = __typename,
        name = name,
        fragments = fragments
      )
    }
  }

  data class Fragments(
    val characterDetails: CharacterDetails?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeFragment(characterDetails?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human", "Droid"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Fragments {
        val characterDetails = reader.readFragment<CharacterDetails>(RESPONSE_FIELDS[0]) { reader ->
          CharacterDetails(reader)
        }
        return Fragments(
          characterDetails = characterDetails
        )
      }
    }
  }
}
