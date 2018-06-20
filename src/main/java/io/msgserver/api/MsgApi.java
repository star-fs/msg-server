/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.msgserver.api;

import io.msgserver.model.ServiceMessage;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Api(value = "msg", description = "the msg API")
public interface MsgApi {

	@ApiOperation(value = "Add a new message", nickname = "addMsg", notes = "Add a new message", response = ServiceMessage.class, tags = { "msg", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation", response = ServiceMessage.class),
			@ApiResponse(code = 400, message = "invalid ID supplied"),
			@ApiResponse(code = 404, message = "message not found") })
	@RequestMapping(value = "/msg", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<ServiceMessage> addMsg(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "msg", required = true) String msg);

	@ApiOperation(value = "Deletes a messge", nickname = "deleteMsg", notes = "", tags = { "msg", })
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid username supplied"),
			@ApiResponse(code = 404, message = "User not found") })
	@RequestMapping(value = "/msg", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteMsg(
			@ApiParam(value = "message id to delete", required = true) @PathVariable("msgId") Long msgId);

	@ApiOperation(value = "Find msg by ID", nickname = "getMsgById", notes = "Returns a single message", response = ServiceMessage.class, tags = { "msg", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation", response = ServiceMessage.class),
			@ApiResponse(code = 400, message = "invalid ID supplied"),
			@ApiResponse(code = 404, message = "message not found") })
	@RequestMapping(value = "/msg", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ServiceMessage> getMsgById(
			@ApiParam(value = "message ID", required = true) @PathVariable("msgId") Long msgId);

	@ApiOperation(value = "Update an existing message", nickname = "updateMsg", notes = "", tags = {
			"msgId", "msg", })
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Msg not found"),
			@ApiResponse(code = 405, message = "Validation exception") })
	@RequestMapping(value = "/msg", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateMsg(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "msg", required = true) String msg,
			@ApiParam(value = "message ID", required = true) @PathVariable("msgId") Long msgId);

}